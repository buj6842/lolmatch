package com.lolmatch.accountinfo.dto

import com.lolmatch.accountinfo.domain.AccountInfo
import com.lolmatch.leagueinfo.domain.LeagueInfo

/**
 * 계정 정보 생성 DTO
 */
data class AccountInfoCreateDTO(
    var riotUserKey: String? = null,
    var encryptAccountId: String? = null,
    var profileIconId: Int? = null,
    var revisionDate: Long? = null,
    var nickname: String? = null,
    var puuid: String? = null,
    var summonerLevel: Long? = null,
    var leagueInfo: LeagueInfo? = null
) {
    fun toEntity() : AccountInfo {
        return AccountInfo(riotUserKey, encryptAccountId, profileIconId, revisionDate, nickname, puuid, summonerLevel)
    }
}