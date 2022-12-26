package com.lolmatch.team.domain

import com.lolmatch.entity.BaseEntity
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_team")
class Team : BaseEntity() {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var teamSeq: Long = 0L

    @Column
    var teamName: String = ""

}