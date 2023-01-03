package com.lolmatch.riot.engine.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.lolmatch.riot.engine.RiotApiResponseCode
import com.lolmatch.riot.engine.model.BanChampion
import kr.co.mcedu.riot.engine.model.Participant

@JsonIgnoreProperties(ignoreUnknown = true)
class CurrentGameInfoResponse : RiotApiResponse() {
    override var state = RiotApiResponseCode.SUCCESS
    var participants: List<Participant> = ArrayList()
    var gameId: Long? = null
    var bannedChampions: List<BanChampion> = ArrayList()
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