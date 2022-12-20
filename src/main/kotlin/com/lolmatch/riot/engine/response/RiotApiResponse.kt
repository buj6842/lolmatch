package com.lolmatch.riot.engine.response

import com.lolmatch.riot.engine.RiotApiResponseCode

abstract class RiotApiResponse {
    open var state = RiotApiResponseCode.DEFAULT
    abstract fun convertToResponse(entityMsg: String): RiotApiResponse
}
