package com.lolmatch.accountinfo.dto

import com.lolmatch.leagueinfo.domain.LeagueInfo

/**
 * 계정 정보 수정 DTO
 */
data class AccountInfoUpdateDTO(
    val accountInfoSeq: Long,
    var riotUserKey: String? = null,
    var encryptAccountId: String? = null,
    var profileIconId: Int? = null,
    var revisionDate: Long? = null,
    var nickname: String? = null,
    var puuid: String? = null,
    var summonerLevel: Long? = null,
    var leagueInfo: LeagueInfo? = null
)