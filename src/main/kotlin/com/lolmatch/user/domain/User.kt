package com.lolmatch.user.domain

import com.lolmatch.accountinfo.domain.AccountInfo
import com.lolmatch.entity.BaseEntity
import com.lolmatch.entity.type.PositionEnum
import com.lolmatch.user.enums.UserRoleType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_user")
class User (
    @Column(name = "user_id")
    var userId: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "phone")
    var phone: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "prefer_position_1")
    var preferPosition1: PositionEnum? = null,

    @Column(name = "prefer_position_2")
    var preferPosition2: PositionEnum? = null
) : BaseEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    val userSeq: Long = 0L

    @Column(name = "old_password")
    var oldPassword: String? = null

    @OneToOne
    @JoinColumn(name = "account_info_seq")
    var accountInfo: AccountInfo? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    var userType: UserRoleType = UserRoleType.USER

    var refreshToken: String? = null
}