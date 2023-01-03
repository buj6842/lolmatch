package com.lolmatch.user.dto

import com.lolmatch.entity.type.PositionEnum
import com.lolmatch.user.domain.AccountInfo
import com.lolmatch.user.domain.LeagueInfo
import com.lolmatch.user.domain.User
import org.springframework.security.crypto.bcrypt.BCrypt

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