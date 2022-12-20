package com.lolmatch.riot.engine.response

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.lolmatch.riot.engine.RiotApiResponseCode
import java.util.*

class SummonerNameSearchResponse : RiotApiResponse() {
    override var state = RiotApiResponseCode.SUCCESS
    var id: String? = null
    var accountId: String? = null
    var puuid: String? = null
    var name: String? = null
    var profileIconId: Int? = null
    var revisionDate: Long? = null
    var summonerLevel: Int? = null
    override fun convertToResponse(entityMsg: String): RiotApiResponse {
        return try {
            ObjectMapper().readValue(entityMsg, this.javaClass)
        } catch (e: JsonProcessingException) {
            val defaultApiResponse = DefaultApiResponse()
            defaultApiResponse.state = RiotApiResponseCode.PARSING_ERROR
            defaultApiResponse
        }
    }
}