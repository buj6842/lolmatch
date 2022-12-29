package com.lolmatch.common.property

import com.lolmatch.common.domain.RiotPropertyEntity

class RiotApiProperty(riotApiProperty: RiotPropertyEntity) {
    val riotApiUrl: String?
    val apiKey: String?

    init {
        riotApiUrl = riotApiProperty?.propertyValue1
        apiKey = riotApiProperty?.propertyValue2
    }
}