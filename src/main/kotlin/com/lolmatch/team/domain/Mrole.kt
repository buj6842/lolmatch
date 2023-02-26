package com.lolmatch.team.domain

import com.lolmatch.team.enums.MemberRoleType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_mrole")
class Mrole {
    @Id
    @Column(name = "m_role_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var mRoleSeq: Long = 0L

    @Column(name = "role_type")
    @Enumerated(EnumType.STRING)
    var roleType: MemberRoleType = MemberRoleType.MEMBER
}