package com.lolmatch.user.domain

import com.lolmatch.entity.AccountInfo
import com.lolmatch.entity.BaseEntity
import com.lolmatch.entity.type.PositionEnum
import com.lolmatch.user.enums.UserRoleType
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@DynamicUpdate
@Entity
@Table(name = "tbl_user")
class User (
    @Column
    var userId: String? = null,

    @Column
    var password: String? = null,

    @Column
    var phone: String? = null,

    @Column
    var email: String? = null,

    @Column
    var preferPosition1: PositionEnum? = null,

    @Column
    var preferPosition2: PositionEnum? = null
) : BaseEntity() {
    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userSeq: Long = 0L

    @Column
    var oldPassword: String? = null

    @OneToOne
    @JoinColumn(name = "account_info_id")
    var accountInfo: AccountInfo? = null

    @Enumerated(EnumType.STRING)
    var userType: UserRoleType = UserRoleType.USER

    var refreshToken: String? = null
}