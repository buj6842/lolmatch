package com.lolmatch.accountinfo.domain

import com.lolmatch.accountinfo.dto.AccountInfoUpdateDTO
import com.lolmatch.entity.BaseEntity
import com.lolmatch.leagueinfo.domain.LeagueInfo
import org.hibernate.annotations.DynamicUpdate
import org.springframework.util.ObjectUtils
import javax.persistence.*

/**
 * 계정 정보(소환사 정보)
 */
@DynamicUpdate
@Entity
@Table(name = "tbl_accountInfo")
class AccountInfo(
    @Column(name = "riot_user_key")
    var riotUserKey: String? = null,

    @Column(name = "encrypt_accountId")
    var encryptAccountId: String? = null,

    @Column(name = "profile_icon_id")
    var profileIconId: Int? = null,

    @Column(name = "revision_date")
    var revisionDate: Long? = null,

    @Column(name = "nickname")
    var nickname: String? = null,

    @Column(name = "puuid")
    var puuid: String? = null,

    @Column(name = "summoner_level")
    var summonerLevel: Long? = null,
): BaseEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_info_seq")
    val accountInfoSeq: Long = 0L

    @OneToOne
    @JoinColumn(name = "league_info_seq")
    var leagueInfo: LeagueInfo? = null

    fun update(accountInfoUpdateDTO: AccountInfoUpdateDTO) {
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.riotUserKey))      riotUserKey = accountInfoUpdateDTO.riotUserKey
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.encryptAccountId)) encryptAccountId = accountInfoUpdateDTO.encryptAccountId
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.profileIconId))    profileIconId = accountInfoUpdateDTO.profileIconId
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.revisionDate))     revisionDate = accountInfoUpdateDTO.revisionDate
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.nickname))         nickname = accountInfoUpdateDTO.nickname
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.puuid))            puuid = accountInfoUpdateDTO.puuid
        if(!ObjectUtils.isEmpty(accountInfoUpdateDTO.summonerLevel))    summonerLevel = accountInfoUpdateDTO.summonerLevel
    }

    fun delete() {
        delYn = true
    }
}