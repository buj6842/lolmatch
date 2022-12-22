package com.lolmatch.user.repository

import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.dto.LoginResponseDTO

interface UserCustomRepository {

    fun getUserByUserName(userName : String) : String

    fun getUserDetailById(loginRequest: LoginRequest) : LoginResponseDTO?
}