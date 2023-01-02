package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_accountInfo")
class AccountInfo: BaseEntity() {
    @Id @GeneratedValue
    val id: Long = 0L

    var riotUserKey: String = ""

    var encryptAccountId: String = ""

    var profileIconId: Int = 0

    var revisionDate: Long = 0L

    var nickName: String = ""

    var puuid: String = ""

    var summonerLevel: Long = 0L

    @OneToOne
    @JoinColumn(name = "league_info_id")
    var leagueInfo: LeagueInfo? = null
}