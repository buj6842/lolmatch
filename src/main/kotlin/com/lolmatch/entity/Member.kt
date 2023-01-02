package com.lolmatch.entity

import com.lolmatch.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_member")
class Member {
    @Id @GeneratedValue
    var id: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null

    @OneToOne
    @JoinColumn(name = "user_seq")
    var user: User? = null
}