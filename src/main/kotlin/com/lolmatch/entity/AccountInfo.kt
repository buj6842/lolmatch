package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "TBL_ACCOUNT_INFO")
class AccountInfo: BaseEntity() {
    @Id
    @Column
    var id: String = ""

    @Column
    var accountId: String = ""

    @Column
    var profileIconId: Int = 0

    @Column
    var puuid: String = ""

    @Column
    var name: String = ""

    @Column
    var revisionDate: Long = 0L

    @Column
    var level: Int = 0

    @Column
    var tier: String = ""

    @Column
    var rank: String = ""

    @Column
    var leaguePoints: Int = 0

    @Column
    var wins: Int = 0

    @Column
    var losses: Int = 0
}