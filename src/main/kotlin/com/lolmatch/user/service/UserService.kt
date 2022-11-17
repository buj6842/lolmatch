package com.lolmatch.user.service

import com.lolmatch.user.dto.UserCreateDTO

interface UserService {

    fun createUser(userCreateDTO: UserCreateDTO)
}