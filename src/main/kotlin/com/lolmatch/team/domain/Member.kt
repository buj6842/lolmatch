package com.lolmatch.team.domain

import com.lolmatch.entity.BaseEntity
import com.lolmatch.user.domain.User
import com.lolmatch.user.enums.UserRoleType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_member")
class Member : BaseEntity() {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var memberSeq: Long = 0L

    @Enumerated(EnumType.STRING)
    var userType: UserRoleType = UserRoleType.USER

    @ManyToOne
    @JoinColumn(name = "team_seq")
    var team : Team? = null

    @OneToOne
    @JoinColumn(name = "user_seq")
    var user: User? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tbl_member_mrole",
        joinColumns = [JoinColumn(name = "member_seq")],
        inverseJoinColumns = [JoinColumn(name = "mrole_seq")]
    )
    val mRoles: List<Mrole>? = mutableListOf()
}