package com.lolmatch.entity

import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "tbl_leagueInfo")
class LeagueInfo {
    @Id @GeneratedValue
    val id: Long = 0L

    var leagueId: String = ""

    // RANKED_FLEX_SR, RANKED_SOLO_5x5
    var queueType: String = ""

    // IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER
    var tier: String = ""

    // 1 ~ 4
    var rank: Int = 0

    // 0 ~ 100
    var leaguePoints: Int = 0

    // 승리횟수
    var wins: Int = 0

    // 패배횟수
    var losses: Int = 0

    // 연승 여부
    var hotStreak: Boolean = false

    // 베테랑 여부
    var veteran: Boolean = false

    // 새내기 여부
    var freshBlood: Boolean = false

    // 비활성화 상태
    var inactive: Boolean = false
}