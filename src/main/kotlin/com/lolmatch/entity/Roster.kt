package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_roster")
class Roster {
    @Id @GeneratedValue
    @Column
    val id: Long = 0L

    @Column // 팀명
    var rosterName: String = ""

    @Column // 탑 userSeq
    var top: Long = 0L

    @Column // 정글 userSeq
    var jungle: Long = 0L

    @Column // 미드 userSeq
    var mid: Long = 0L

    @Column // 원딜 userSeq
    var ad: Long = 0L

    @Column // 서폿 userSeq
    var support: Long = 0L

    @Column // 예비 userSeq
    var spare: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null
}