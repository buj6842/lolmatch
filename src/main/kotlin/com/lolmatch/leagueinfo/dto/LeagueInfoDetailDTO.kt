package com.lolmatch.leagueinfo.dto

import com.lolmatch.leagueinfo.enums.QueueType
import com.lolmatch.leagueinfo.enums.TierType

/**
 * 리그 정보 상세 DTO
 */
data class LeagueInfoDetailDTO(
    val leagueInfoSeq: Long,
    val leagueId: String? = null,
    val queueType: QueueType? = null,
    val tier: TierType? = null,
    val rank: Int? = null,
    val leaguePoints: Int? = null,
    val wins: Int? = null,
    val losses: Int? = null,
    val hotStreak: Boolean? = null,
    val veteran: Boolean? = null,
    val freshBlood: Boolean? = null,
    val inactive: Boolean? = null
)