package com.lolmatch.service

import com.lolmatch.entity.AccountInfo
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import net.minidev.json.parser.JSONParser
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import java.util.stream.Collectors

@Service
class RiotService {
    @Value("\${riot.url}")
    private lateinit var baseUrl: String
    private val webClient: WebClient = WebClient.create(baseUrl)

    private val key = "RGAPI-4698535a-c2fa-4452-b80b-f14c77680b95"

    fun getAccountInfoBySummonerName(summonerName: String) {
        val account = AccountInfo()
        try{
            val httpClient = HttpClientBuilder.create().build()
            val request = HttpGet("$baseUrl/lol/summoner/v4/summoners/by-name/$summonerName")
            val response = httpClient.execute(request)

            if(response.statusLine.statusCode == 200) {
                val handler = BasicResponseHandler()
                val body = handler.handleResponse(response)
                val jsonParser = JSONParser()
                val jsonObject = jsonParser.parse(body) as JSONObject

                account.id = jsonObject["id"].toString()
                account.accountId = jsonObject["accountId"].toString()
                account.profileIconId = jsonObject["profileIconId"] as Int
                account.puuid = jsonObject["puuid"].toString()
                account.name = jsonObject["name"].toString()
                account.revisionDate = jsonObject["revisionDate"] as Long
                account.level = jsonObject["level"] as Int
            }

        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun getLeagueInfoBySummonerId(id: String): JSONObject {
        var returnJson = JSONObject()
        try {
            val body: List<String> = webClient.get()
                .uri { uriBuilder ->
                    uriBuilder.path("/lol/league/v4/entries/by-summoner/$id")
                        .queryParam("api_key", key).build()
                }
                .retrieve()
                .bodyToFlux(String::class.java)
                .toStream()
                .collect(Collectors.toList())

            val jsonParser = JSONParser()
            val jsonArray: JSONArray = jsonParser.parse(body[0]) as JSONArray

            for (i in 0 until jsonArray.size) {
                val jsonObject = jsonArray[i] as JSONObject
                if (jsonObject["queueType"].toString() == "RANKED_FLEX_SR") {
                    returnJson = jsonObject
                }
            }
        } catch(e: Exception) {
            e.stackTrace
        }
        return returnJson
    }
}