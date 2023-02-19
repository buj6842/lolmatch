//package com.lolmatch.service
//
//import com.lolmatch.entity.AccountInfo
//import com.lolmatch.repository.AccountInfoRepository
//import net.minidev.json.JSONArray
//import net.minidev.json.JSONObject
//import net.minidev.json.parser.JSONParser
//import org.apache.http.client.methods.HttpGet
//import org.apache.http.impl.client.BasicResponseHandler
//import org.apache.http.impl.client.HttpClientBuilder
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.stereotype.Service
//import org.springframework.web.reactive.function.client.WebClient
//import java.util.stream.Collectors
//
//@Service
//class RiotService {
//    @Value("\${riot.url}")
//    private val baseUrl = ""
//    @Value("\${riot.key}")
//    private val key = ""
//
//    @Autowired
//    private lateinit var accountInfoRepository: AccountInfoRepository
//
//    fun getAccountInfoBySummonerName(summonerName: String) {
//        val account = AccountInfo()
//        try{
//            val httpClient = HttpClientBuilder.create().build()
//            val sb: StringBuilder = StringBuilder()
//            sb.append(baseUrl).append("lol/summoner/v4/summoners/by-name/").append(summonerName).append("?api_key=").append(key)
//            val request = HttpGet(sb.toString())
//            val response = httpClient.execute(request)
//
//            if(response.statusLine.statusCode == 200) {
//                val handler = BasicResponseHandler()
//                val body = handler.handleResponse(response)
//                val accountInfoJson = JSONParser().parse(body) as JSONObject
//
//
//            }
//
//        } catch (e: Exception) {
//            e.stackTrace
//        }
//    }
//
//    fun getLeagueInfoBySummonerId(id: String) {
//        val sb: StringBuilder = StringBuilder()
//        sb.append(baseUrl).append("lol/league/v4/entries/by-summoner/").append(id)
//
//        val webClient: WebClient = WebClient.builder().baseUrl(sb.toString()).build()
//
//        try {
//            val body: List<String> = webClient.get()
//                .uri { uriBuilder -> uriBuilder.path("")
//                    .queryParam("api_key", key).build()
//                }
//                .retrieve()
//                .bodyToFlux(String::class.java)
//                .toStream()
//                .collect(Collectors.toList())
//
//            val jsonParser = JSONParser()
//            val jsonArray: JSONArray = jsonParser.parse(body[0]) as JSONArray
//
//            for (i in 0 until jsonArray.size) {
//                val jsonObject = jsonArray[i] as JSONObject
//                if (jsonObject["queueType"].toString() == "RANKED_FLEX_SR") {
//                }
//            }
//        } catch(e: Exception) {
//            e.stackTrace
//        }
//    }
//}