package com.lolmatch.riot.engine

import com.lolmatch.util.StringUtils.randomStringGenerate
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class RiotApiRequest(
    var messageKey: String = randomStringGenerate(6),
    var apiType: RiotApiType = RiotApiType.DEFAULT
) {
    var data: MutableMap<String, Any> = HashMap()
    val url: String
        get() {
            var urlTemplate = apiType.url
            var encodedValue: String?
            for ((key, value) in data) {
                encodedValue = URLEncoder.encode(value.toString(), StandardCharsets.UTF_8.toString())
                urlTemplate = urlTemplate.replace("{$key}", encodedValue)
            }
            return urlTemplate
        }
}