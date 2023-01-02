package com.lolmatch.team.domain

import com.lolmatch.entity.BaseEntity
import com.lolmatch.team.enums.MemberRoleType
import com.lolmatch.user.domain.User
import com.lolmatch.user.enums.UserRoleType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_member")
class Member(
    @Column(name = "m_role_type")
    @Enumerated(EnumType.STRING)
    var mRoleType: MemberRoleType = MemberRoleType.MEMBER,

    @ManyToOne
    @JoinColumn(name = "team_seq")
    var team : Team? = null,

    @OneToOne
    @JoinColumn(name = "user_seq")
    var user: User? = null
) : BaseEntity() {

    @Id
    @Column(name = "member_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var memberSeq: Long = 0L

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tbl_member_mrole",
        joinColumns = [JoinColumn(name = "member_seq")],
        inverseJoinColumns = [JoinColumn(name = "mrole_seq")]
    )
    val mRoles: MutableSet<Mrole>? = mutableSetOf()
}