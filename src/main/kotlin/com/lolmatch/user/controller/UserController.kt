package com.lolmatch.user.controller

import com.lolmatch.user.dto.UserCreateDTO
import com.lolmatch.user.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    /**
     * 회원가입
     */
    @PostMapping("/user")
    fun createUser(@RequestBody createDTO: UserCreateDTO) {
        userService.createUser(createDTO)
    }
}