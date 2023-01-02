package com.lolmatch.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

/**
 * 리그 정보(계급, 승패, 리그 내 상태)
 */
@DynamicUpdate
@Entity
@Table(name = "tbl_leagueInfo")
class LeagueInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_info_seq")
    val leagueInfoSeq: Long = 0L

    @Column(name = "league_id")
    var leagueId: String = ""

    // RANKED_FLEX_SR, RANKED_SOLO_5x5
    @Column(name = "queue_type")
    var queueType: String = ""

    // IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER
    @Column(name = "tier")
    var tier: String = ""

    // 1 ~ 4
    @Column(name = "rank")
    var rank: Int = 0

    // 0 ~ 100
    @Column(name = "league_points")
    var leaguePoints: Int = 0

    // 승리횟수
    @Column(name = "wins")
    var wins: Int = 0

    // 패배횟수
    @Column(name = "losses")
    var losses: Int = 0

    // 연승 여부
    @Column(name = "hot_streak")
    var hotStreak: Boolean = false

    // 베테랑 여부
    @Column(name = "veteran")
    var veteran: Boolean = false

    // 새내기 여부
    @Column(name = "fresh_blood")
    var freshBlood: Boolean = false

    // 비활성화 상태
    @Column(name = "inactive")
    var inactive: Boolean = false
}