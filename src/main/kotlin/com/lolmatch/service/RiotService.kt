package com.lolmatch.service

import com.lolmatch.entity.AccountInfo
import com.lolmatch.repository.AccountInfoRepository
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import net.minidev.json.parser.JSONParser
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import java.util.stream.Collectors

@Service
class RiotService {
    @Value("\${riot.url}") private lateinit var baseUrl: String
    @Value("\${riot.key}") private lateinit var key: String

    @Autowired
    private lateinit var accountInfoRepository: AccountInfoRepository

    private val webClient: WebClient = WebClient.create(baseUrl)
    fun getAccountInfoBySummonerName(summonerName: String) {
        val account = AccountInfo()
        try{
            val httpClient = HttpClientBuilder.create().build()
            val sb: StringBuilder = StringBuilder()
            sb.append(baseUrl).append("l/lol/summoner/v4/summoners/by-name/").append(summonerName).append("?api_key=").append(key)
            val request = HttpGet(sb.toString())
            val response = httpClient.execute(request)

            if(response.statusLine.statusCode == 200) {
                val handler = BasicResponseHandler()
                val body = handler.handleResponse(response)
                val jsonParser = JSONParser()
                val accountInfoJson = jsonParser.parse(body) as JSONObject

                account.id = accountInfoJson["id"].toString()
                account.accountId = accountInfoJson["accountId"].toString()
                account.profileIconId = accountInfoJson["profileIconId"] as Int
                account.puuid = accountInfoJson["puuid"].toString()
                account.name = accountInfoJson["name"].toString()
                account.revisionDate = accountInfoJson["revisionDate"] as Long
                account.level = accountInfoJson["level"] as Int

                val leagueInfoJson = getLeagueInfoBySummonerId(account.id)

                account.tier = leagueInfoJson["tier"].toString()
                account.rank = leagueInfoJson["rank"].toString()
                account.leaguePoints = leagueInfoJson["leaguePoints"] as Int
                account.wins = leagueInfoJson["wins"] as Int
                account.losses = leagueInfoJson["losses"] as Int


            }

        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun getLeagueInfoBySummonerId(id: String): JSONObject {
        var returnJson = JSONObject()
        val sb: StringBuilder = StringBuilder()
        sb.append("/lol/league/v4/entries/by-summoner/").append(id)
        try {
            val body: List<String> = webClient.get()
                .uri { uriBuilder ->
                    uriBuilder.path(sb.toString())
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