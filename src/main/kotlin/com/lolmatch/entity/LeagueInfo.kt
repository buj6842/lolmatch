package com.lolmatch.entity

import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "tbl_leagueInfo")
class LeagueInfo {
    @Id @GeneratedValue
    @Column(name = "id")
    val id: Long = 0L

    @Column
    var leagueId: String = ""

    @Column // RANKED_FLEX_SR, RANKED_SOLO_5x5
    var queueType: String = ""

    @Column // IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER
    var tier: String = ""

    @Column // 1 ~ 4
    var rank: Int = 0

    @Column // 0 ~ 100
    var leaguePoints: Int = 0

    @Column // 승리횟수
    var wins: Int = 0

    @Column // 패배횟수
    var losses: Int = 0

    @Column // 연승 여부
    var hotStreak: Boolean = false

    @Column // 베테랑 여부
    var veteran: Boolean = false

    @Column // 새내기 여부
    var freshBlood: Boolean = false

    @Column // 비활성화 상태
    var inactive: Boolean = false
}