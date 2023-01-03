package com.lolmatch.roster.domain

import com.lolmatch.entity.BaseEntity
import com.lolmatch.roster.dto.RosterUpdateDTO
import com.lolmatch.team.domain.Team
import org.hibernate.annotations.DynamicUpdate
import org.springframework.util.ObjectUtils
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_roster")
class Roster(
    @Column(name = "roster_name")
    var rosterName: String? = null
): BaseEntity() {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_seq")
    var team: Team? = null

    fun update (rosterUpdateDTO: RosterUpdateDTO) {
        if(ObjectUtils.isEmpty(rosterUpdateDTO.rosterName)) rosterName = rosterUpdateDTO.rosterName
        if(ObjectUtils.isEmpty(rosterUpdateDTO.top))        top = rosterUpdateDTO.top
        if(ObjectUtils.isEmpty(rosterUpdateDTO.jungle))     jungle = rosterUpdateDTO.jungle
        if(ObjectUtils.isEmpty(rosterUpdateDTO.mid))        mid = rosterUpdateDTO.mid
        if(ObjectUtils.isEmpty(rosterUpdateDTO.ad))         ad = rosterUpdateDTO.ad
        if(ObjectUtils.isEmpty(rosterUpdateDTO.support))    support = rosterUpdateDTO.support
        if(ObjectUtils.isEmpty(rosterUpdateDTO.spare))      spare = rosterUpdateDTO.spare
    }

    fun delete() {
        delYn = true
    }
}