package com.lolmatch.user.dto


import com.lolmatch.user.enums.UserRoleType
import com.querydsl.core.annotations.QueryProjection

class UserDetailDTO @QueryProjection constructor(
    val userSeq: Long? = null,
    var userId: String? = null,
    var password: String? = null,
    var oldPassword: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var preferPosition1: String? = null,
    var preferPosition2: String? = null,
    var userType: UserRoleType? = null
) {

}