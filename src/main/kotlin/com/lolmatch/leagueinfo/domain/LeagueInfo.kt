package com.lolmatch.leagueinfo.domain

import com.lolmatch.entity.BaseEntity
import com.lolmatch.leagueinfo.dto.LeagueInfoUpdateDTO
import com.lolmatch.leagueinfo.enums.QueueType
import com.lolmatch.leagueinfo.enums.TierType
import org.hibernate.annotations.DynamicUpdate
import org.springframework.util.ObjectUtils
import javax.persistence.*

/**
 * 리그 정보(계급, 승패, 리그 내 상태)
 */
@DynamicUpdate
@Entity
@Table(name = "tbl_leagueInfo")
class LeagueInfo(
    @Column(name = "league_id")
    var leagueId: String? = null,

    @Column(name = "queue_type")
    @Enumerated(EnumType.STRING)
    var queueType: QueueType? = null,

    @Column(name = "tier")
    @Enumerated(EnumType.STRING)
    var tier: TierType? = null,

    // 1 ~ 4
    @Column(name = "rank")
    var rank: Int? = null,

    // 0 ~ 100
    @Column(name = "league_points")
    var leaguePoints: Int? = null,

    // 승리횟수
    @Column(name = "wins")
    var wins: Int? = null,

    // 패배횟수
    @Column(name = "losses")
    var losses: Int? = null,

    // 연승 여부
    @Column(name = "hot_streak")
    var hotStreak: Boolean? = null,

    // 베테랑 여부
    @Column(name = "veteran")
    var veteran: Boolean? = null,

    // 새내기 여부
    @Column(name = "fresh_blood")
    var freshBlood: Boolean? = null,

    // 비활성화 상태
    @Column(name = "inactive")
    var inactive: Boolean? = null,
): BaseEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_info_seq")
    val leagueInfoSeq: Long = 0L

    fun update(leagueInfoUpdateDTO: LeagueInfoUpdateDTO) {
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.leagueId))     leagueId = leagueInfoUpdateDTO.leagueId
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.queueType))    queueType = leagueInfoUpdateDTO.queueType
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.tier))         tier = leagueInfoUpdateDTO.tier
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.rank))         rank = leagueInfoUpdateDTO.rank
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.leaguePoints)) leaguePoints = leagueInfoUpdateDTO.leaguePoints
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.wins))         wins = leagueInfoUpdateDTO.wins
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.losses))       losses = leagueInfoUpdateDTO.losses
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.hotStreak))    hotStreak = leagueInfoUpdateDTO.hotStreak
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.veteran))      veteran = leagueInfoUpdateDTO.veteran
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.freshBlood))   freshBlood = leagueInfoUpdateDTO.freshBlood
        if(!ObjectUtils.isEmpty(leagueInfoUpdateDTO.inactive))     inactive = leagueInfoUpdateDTO.inactive
    }

    fun delete() {
        delYn = true
    }
}