package com.lolmatch.team.domain

import com.lolmatch.entity.BaseEntity
import com.lolmatch.team.enums.MemberRoleType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_mrole")
class Mrole : BaseEntity() {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var mRoleSeq: Long = 0L

    @Column
    @Enumerated(EnumType.STRING)
    var roleType: MemberRoleType = MemberRoleType.MEMBER
}