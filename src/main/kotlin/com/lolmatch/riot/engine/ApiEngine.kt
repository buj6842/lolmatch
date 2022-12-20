package com.lolmatch.riot.engine

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.lolmatch.common.property.RiotApiProperty
import com.lolmatch.util.TimeUtils
import com.lolmatch.util.TimeUtils.now
import com.lolmatch.util.exception.ServiceException
import com.lolmatch.riot.engine.RiotApiResponseCode.Companion.findByState
import com.lolmatch.riot.engine.response.DefaultApiResponse
import com.lolmatch.riot.engine.response.RiotApiResponse
import com.lolmatch.riot.engine.response.TimeOutApiResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

@Component
class ApiEngine {
    private lateinit var apiShooter: ApiShooter
    private val log = LoggerFactory.getLogger(ApiEngine::class.java)
    fun init(riotApiProperty: RiotApiProperty?) {
        riotApiProperty?: throw ServiceException("잘못된 라이엇 api정보입니다.")
        apiShooter = ApiShooter(riotApiProperty, log)
        apiShooter.validationCheck()
        apiShooter.start()
    }

    fun sendRequest(request: RiotApiRequest): RiotApiResponse {
        val messageKey = request.messageKey
        apiShooter.request.offer(request)
        val startTime = now()
        while (System.currentTimeMillis() - startTime < 10 * TimeUtils.SECONDS_AS_MILLISECONDS) {
            apiShooter.response.getIfPresent(messageKey)?.let {
                return it
            }
            try {
                Thread.sleep(100)
            } catch (ignore: InterruptedException) {
            }
        }
        return TimeOutApiResponse()
    }

    fun updateApiProperty(riotApiProperty: RiotApiProperty) {
        apiShooter.riotApiProperty = riotApiProperty
        log.info("key update 완료")
    }

    private class ApiShooter(var riotApiProperty: RiotApiProperty, var log: Logger) : Thread() {
        val request = LinkedBlockingQueue<RiotApiRequest>()
        val response = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build<String, RiotApiResponse>()
        private val state = true
        private var isValidationProperty = false
        private val engineCount = EngineCount()
        override fun run() {
            while (state) {
                try {
                    val message = request.take()
                    if (!engineCount.innerTime.plusSeconds(1).isBefore(LocalDateTime.now())) {
                        engineCount.innerCount = 0
                        engineCount.innerTime = LocalDateTime.now()
                    }
                    if (!engineCount.outerTime.plusMinutes(2).isBefore(LocalDateTime.now())) {
                        engineCount.outerCount = 0
                        engineCount.outerTime = LocalDateTime.now()
                    }
                    if (engineCount.innerCount >= 20) {
                        while (!engineCount.innerTime.plusSeconds(1).isBefore(LocalDateTime.now())) {
                            sleep(100)
                        }
                        engineCount.innerCount = 0
                        engineCount.innerTime = LocalDateTime.now()
                    }
                    if (engineCount.outerCount >= 100) {
                        while (!engineCount.outerTime.plusMinutes(2).isBefore(LocalDateTime.now())) {
                            sleep(100)
                        }
                        engineCount.outerCount = 0
                        engineCount.outerTime = LocalDateTime.now()
                    }
                    engineCount.innerCount++
                    engineCount.outerCount++
                    if (!isValidationProperty) {
                        val defaultApiResponse = DefaultApiResponse().apply {
                            state = RiotApiResponseCode.PROPERTY_ERROR
                        }
                        response.put(message.messageKey, defaultApiResponse)
                    } else {
                        InnerShooter(riotApiProperty, message, response, log).start()
                    }
                } catch (ignore: InterruptedException) {
                }
            }
        }

        fun validationCheck() {
            isValidationProperty = !riotApiProperty.apiKey.isNullOrEmpty() && !riotApiProperty.riotApiUrl.isNullOrEmpty()
        }

        private class EngineCount {
            var innerCount = 0
            var innerTime = LocalDateTime.now()
            var outerCount = 0
            var outerTime = LocalDateTime.now()
        }

        private class InnerShooter(
            private val riotApiProperty: RiotApiProperty,
            private val message: RiotApiRequest,
            private val cache: Cache<String, RiotApiResponse>,
            private val log: Logger
        ) : Thread() {
            override fun run() {
                val start = now()
                try {
                    cache.put(message.messageKey, sendRequest(message))
                } catch (e: Exception) {
                    log.error("", e)
                }
                log.info(message.apiType.msg + " " + (now() - start) + "ms")
            }

            @Throws(Exception::class)
            private fun sendRequest(message: RiotApiRequest): RiotApiResponse {
                val request = HttpGet(URIBuilder(riotApiProperty.riotApiUrl + message.url).build())
                request.setHeader("X-Riot-Token", riotApiProperty.apiKey)
                val response = HttpClientBuilder.create().build().execute(request)
                val msg = EntityUtils.toString(response.entity)
                log.info("response : $msg")
                val responseCode = findByState(response.statusLine.statusCode.toString())
                if (responseCode === RiotApiResponseCode.SUCCESS) {
                    val responseType = message.apiType.responseType as Class<*>
                    val newInstance = responseType.getDeclaredConstructor().newInstance()
                    return if (newInstance is RiotApiResponse) {
                        newInstance.convertToResponse(msg)
                    } else {
                        DefaultApiResponse()
                    }
                }
                return DefaultApiResponse()
            }
        }
    }
}