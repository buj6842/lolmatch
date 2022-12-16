package com.lolmatch.common.property

class RiotApiProperty (riotApiProperty: RiotApiProperty?) {
    val riotApiUrl: String?
    val apiKey: String?

    init {
        riotApiUrl = riotApiProperty?.riotApiUrl
        apiKey = riotApiProperty?.apiKey
    }
}