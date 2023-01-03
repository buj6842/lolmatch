package kr.co.mcedu.riot.engine.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.lolmatch.riot.engine.model.Rune

@JsonIgnoreProperties(ignoreUnknown = true)
class Participant {
    var summonerId: String? = null
    var teamId: Long? = null
    var spell1Id: Long? = null
    var spell2Id: Long? = null
    var championId: Long? = null
    var championName: String? = null
    var championImage: String? = null
    var perks: Rune? = null
}