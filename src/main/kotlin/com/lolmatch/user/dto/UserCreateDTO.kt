package com.lolmatch.user.dto

import com.lolmatch.entity.type.PositionEnum
import com.lolmatch.user.domain.User
import org.springframework.security.crypto.bcrypt.BCrypt

data class UserCreateDTO(val builder: Builder) {
    private var userId: String? = builder.userId
    private var password: String? = builder.password
    private var phone: String? = builder.phone
    private var email: String? = builder.email
    private var preferPosition1: PositionEnum? = builder.preferPosition1
    private var preferPosition2: PositionEnum? = builder.preferPosition2

    open class Builder() {
        // 필수 파라미터
        lateinit var userId: String
        lateinit var password: String

        // 선택 파라미터
        var phone: String = ""
        var email: String = ""
        var preferPosition1: PositionEnum? = null
        var preferPosition2: PositionEnum? = null

        constructor(userId: String, password: String): this() {
            this.userId = userId
            this.password = password
        }

        fun phone(phone: String): Builder {
            this.phone = phone
            return this
        }
        fun email(email: String): Builder {
            this.email = email
            return this
        }
        fun preferPosition1(preferPosition: PositionEnum): Builder {
            this.preferPosition1 = preferPosition
            return this
        }
        fun preferPosition2(preferPosition: PositionEnum): Builder {
            this.preferPosition2= preferPosition
            return this
        }
        fun build(): UserCreateDTO {
            return UserCreateDTO(this)
        }
    }

    fun toEntity() : User {
        return User(userId, BCrypt.hashpw(password, BCrypt.gensalt()), phone, email, preferPosition1, preferPosition2)
    }
}