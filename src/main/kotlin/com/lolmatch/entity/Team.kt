package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_team")
class Team : BaseEntity() {
    @Id @GeneratedValue
    @Column
    val id: Long = 0L

    @Column
    val teamName: String = ""

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL], orphanRemoval = true)
    val member: List<Member> = ArrayList()

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL], orphanRemoval = true)
    val roster: List<Roster> = ArrayList()
}