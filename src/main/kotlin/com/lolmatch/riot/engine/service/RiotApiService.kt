package com.lolmatch.riot.engine.service

import com.lolmatch.riot.engine.response.SummonerNameSearchResponse

interface RiotApiService {

    fun getRiotInfo(summonerName : String) : SummonerNameSearchResponse
}