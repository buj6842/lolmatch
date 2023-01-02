package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_roster")
class Roster {
    @Id @GeneratedValue
    val id: Long = 0L

    var rosterName: String = ""

    var top: Long = 0L

    var jungle: Long = 0L

    var mid: Long = 0L

    var ad: Long = 0L

    var support: Long = 0L

    var spare: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null
}