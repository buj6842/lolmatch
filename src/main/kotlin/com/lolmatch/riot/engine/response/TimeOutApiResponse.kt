package com.lolmatch.riot.engine.response

import com.lolmatch.riot.engine.RiotApiResponseCode

class TimeOutApiResponse : RiotApiResponse() {
    override var state = RiotApiResponseCode.TIMEOUT
    override fun convertToResponse(entityMsg: String): RiotApiResponse {
        return TimeOutApiResponse()
    }
}