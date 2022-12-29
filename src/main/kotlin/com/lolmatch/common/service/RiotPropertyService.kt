package com.lolmatch.common.service

import com.lolmatch.common.property.RiotApiProperty

interface RiotPropertyService {
    val riotApiProperty: RiotApiProperty?

    fun updateRiotApiProperty(apiKey: String?)
}