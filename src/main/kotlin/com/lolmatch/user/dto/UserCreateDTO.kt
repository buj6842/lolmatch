package com.lolmatch.user.dto

import com.lolmatch.user.domain.User
import com.querydsl.core.annotations.QueryProjection
import org.springframework.security.crypto.bcrypt.BCrypt

data class UserCreateDTO(
    var userId: String? = null,
    var password: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var preferPosition1: String? = null,
    var preferPosition2: String? = null
) {

    fun toEntity() : User {
        return User(userId,BCrypt.hashpw(password, BCrypt.gensalt()),phone,email,preferPosition1,preferPosition2)
    }
}