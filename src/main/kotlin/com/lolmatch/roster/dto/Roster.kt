package com.lolmatch.roster.dto

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_roster")
class Roster(
    @Column(name = "roster_name")
    var rosterName: String? = null
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roster_seq")
    val rosterSeq: Long = 0L

    @Column(name = "top")
    var top: Long? = null

    @Column(name = "jungle")
    var jungle: Long? = null

    @Column(name = "mid")
    var mid: Long? = null

    @Column(name = "ad")
    var ad: Long? = null

    @Column(name = "support")
    var support: Long? = null

    @Column(name = "spare")
    var spare: Long? = null

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_seq")
//    var team: Team? = null

    fun update (rosterUpdateDTO: RosterUpdateDTO) {
        if(rosterUpdateDTO.rosterName != null) {
            rosterName = rosterUpdateDTO.rosterName
        }
        if(rosterUpdateDTO.top != null) {
            top = rosterUpdateDTO.top
        }
        if(rosterUpdateDTO.jungle != null) {
            jungle = rosterUpdateDTO.jungle
        }
        if(rosterUpdateDTO.mid != null) {
            mid = rosterUpdateDTO.mid
        }
        if(rosterUpdateDTO.ad != null) {
            ad = rosterUpdateDTO.ad ?: ad
        }
        if(rosterUpdateDTO.support != null) {
            support = rosterUpdateDTO.support ?: support
        }
        if(rosterUpdateDTO.spare != null) {
            spare = rosterUpdateDTO.spare ?: spare
        }
    }
}