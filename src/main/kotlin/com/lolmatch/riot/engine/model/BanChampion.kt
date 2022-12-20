package com.lolmatch.riot.engine.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class BanChampion {
    var championId: Long? = null
    var championName: String? = null
    var championImage: String? = null
    var teamId: Long? = null
    var pickTurn: Long? = null
}