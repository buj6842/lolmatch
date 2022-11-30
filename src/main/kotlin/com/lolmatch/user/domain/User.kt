package com.lolmatch.user.domain

import com.lolmatch.entity.AccountInfo
import com.lolmatch.entity.BaseEntity
import com.lolmatch.entity.type.PositionEnum
import com.lolmatch.user.enums.UserRoleType
import javax.persistence.*

@Entity
@Table(name = "TBL_USER")
data class User (
    @Id
    @GeneratedValue
    val userSeq: Long? = null,
    @Column
    var userId: String,
    @Column
    var password: String,
    @Column
    var phone: String,
    @Column
    var email: String,
    @Column
    var preferPosition1: PositionEnum,
    @Column
    var preferPosition2: PositionEnum,
    @Column
    var oldPassword: String,

    @OneToOne
    @JoinColumn(name = "account_info_id")
    var accountInfo: AccountInfo,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    var userType: Set<UserRoleType>
) : BaseEntity() {
}