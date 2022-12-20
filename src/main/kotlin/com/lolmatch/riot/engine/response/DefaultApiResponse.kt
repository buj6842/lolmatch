package com.lolmatch.riot.engine.response

class DefaultApiResponse : RiotApiResponse() {
    override fun convertToResponse(entityMsg: String): RiotApiResponse {
        return DefaultApiResponse()
    }
}