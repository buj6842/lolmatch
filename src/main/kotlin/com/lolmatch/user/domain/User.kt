package com.lolmatch.user.domain

import com.lolmatch.entity.AccountInfo
import com.lolmatch.entity.BaseEntity
import com.lolmatch.user.enums.UserRoleType
import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class User (
    @Column
    var userId: String? = null ,
    @Column
    var password: String? = null,
    @Column
    var oldPassword: String? = null,
    @Column
    var phone: String? = null,
    @Column
    var email: String? = null,
    @Column
    var preferPosition1: String? = null,
    @Column
    var preferPosition2: String? = null
) : BaseEntity() {
    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userSeq: Long = 0L

    @OneToOne
    @JoinColumn(name = "account_info_id")
    var accountInfo: AccountInfo? = null

    @Enumerated(EnumType.STRING)
    var userType: UserRoleType = UserRoleType.USER
}