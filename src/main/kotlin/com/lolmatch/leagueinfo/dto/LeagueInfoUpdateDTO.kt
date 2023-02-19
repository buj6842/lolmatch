package com.lolmatch.leagueinfo.dto

import com.lolmatch.leagueinfo.enums.QueueType
import com.lolmatch.leagueinfo.enums.TierType

/**
 * 리그 정보 수정 DTO
 */
data class LeagueInfoUpdateDTO(
    val leagueInfoSeq: Long,
    var leagueId: String? = null,
    var queueType: QueueType? = null,
    var tier: TierType? = null,
    var rank: Int? = null,
    var leaguePoints: Int? = null,
    var wins: Int? = null,
    var losses: Int? = null,
    var hotStreak: Boolean? = null,
    var veteran: Boolean? = null,
    var freshBlood: Boolean? = null,
    var inactive: Boolean? = null
)