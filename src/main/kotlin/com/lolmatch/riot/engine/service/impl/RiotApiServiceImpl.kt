package com.lolmatch.riot.engine.service.impl

import com.lolmatch.riot.engine.ApiEngine
import com.lolmatch.riot.engine.RiotApiRequest
import com.lolmatch.riot.engine.RiotApiType
import com.lolmatch.riot.engine.response.SummonerNameSearchResponse
import com.lolmatch.riot.engine.service.RiotApiService
import org.springframework.stereotype.Service

@Service
class RiotApiServiceImpl (
    private val apiEngine: ApiEngine
) : RiotApiService
{
    override fun getRiotInfo(summonerName: String): SummonerNameSearchResponse {
        val response = RiotApiRequest().apply {
            apiType = RiotApiType.SUMMONER
            data["summonerName"] = summonerName
        }.let {
            apiEngine.sendRequest(it)
        }
        return if (response is SummonerNameSearchResponse) {
            response
        } else SummonerNameSearchResponse()
    }
}