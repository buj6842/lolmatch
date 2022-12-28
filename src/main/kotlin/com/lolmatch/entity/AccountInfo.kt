package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_accountInfo")
class AccountInfo: BaseEntity() {
    @Id @GeneratedValue
    @Column(name = "id")
    val id: Long = 0L

    @Column(name = "riot_user_key")
    var riotUserKey: String = ""

    @Column
    var encryptAccountId: String = ""

    @Column
    var profileIconId: Int = 0

    @Column
    var revisionDate: Long = 0L

    @Column
    var nickName: String = ""

    @Column
    var puuid: String = ""

    @Column
    var summonerLevel: Long = 0L

    @OneToOne
    @JoinColumn(name = "league_info_id")
    var leagueInfo: LeagueInfo? = null
}