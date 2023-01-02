package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_roster")
class Roster {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roster_seq")
    val rosterSeq: Long = 0L

    @Column(name = "roster_name")
    var rosterName: String = ""

    @Column(name = "top")
    var top: Long = 0L

    @Column(name = "jungle")
    var jungle: Long = 0L

    @Column(name = "mid")
    var mid: Long = 0L

    @Column(name = "ad")
    var ad: Long = 0L

    @Column(name = "support")
    var support: Long = 0L

    @Column(name = "spare")
    var spare: Long = 0L

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_seq")
//    var team: Team? = null
}