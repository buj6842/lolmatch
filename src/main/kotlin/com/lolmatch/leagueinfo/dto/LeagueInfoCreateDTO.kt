package com.lolmatch.leagueinfo.dto

import com.lolmatch.leagueinfo.domain.LeagueInfo
import com.lolmatch.leagueinfo.enums.QueueType
import com.lolmatch.leagueinfo.enums.TierType

/**
 * 리그 정보 생성 DTO
 */
data class LeagueInfoCreateDTO(
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
) {
    fun toEntity() : LeagueInfo {
        return LeagueInfo(leagueId, queueType, tier, rank, leaguePoints, wins, losses, hotStreak, veteran, freshBlood, inactive)
    }
}