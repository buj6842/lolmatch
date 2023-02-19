package com.lolmatch.accountinfo.dto

import com.lolmatch.leagueinfo.domain.LeagueInfo

/**
 * 계정 정보 상세 DTO
 */
data class AccountInfoDetailDTO(
    val accountInfoSeq: Long,
    val riotUserKey: String? = null,
    val encryptAccountId: String? = null,
    val profileIconId: Int? = null,
    val revisionDate: Long? = null,
    val nickname: String? = null,
    val puuid: String? = null,
    val summonerLevel: Long? = null,
    val leagueInfo: LeagueInfo? = null
)