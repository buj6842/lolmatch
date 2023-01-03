package com.lolmatch.user.service

import com.lolmatch.user.domain.User
import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.dto.UserCreateDTO

interface UserService {

    fun createUser(userCreateDTO: UserCreateDTO)

    fun findUser(userSeq: Long?): User

    fun getAccessToken(refreshToken : String?) : String

    fun login(loginRequest: LoginRequest) : String

    fun duplicateCheck(userId : String) : Boolean
}
