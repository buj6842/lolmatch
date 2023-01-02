package com.lolmatch.user.domain

import com.lolmatch.entity.BaseEntity
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

/**
 * 계정 정보(소환사 정보)
 */
@DynamicUpdate
@Entity
@Table(name = "tbl_accountInfo")
class AccountInfo: BaseEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_info_seq")
    val accountInfoSeq: Long = 0L

    @Column(name = "riot_user_key")
    var riotUserKey: String = ""

    @Column(name = "encrypt_accountId")
    var encryptAccountId: String = ""

    @Column(name = "profile_icon_id")
    var profileIconId: Int = 0

    @Column(name = "revision_date")
    var revisionDate: Long = 0L

    @Column(name = "nickname")
    var nickname: String = ""

    @Column(name = "puuid")
    var puuid: String = ""

    @Column(name = "summoner_level")
    var summonerLevel: Long = 0L

    @OneToOne
    @JoinColumn(name = "league_info_seq")
    var leagueInfo: LeagueInfo? = null
}