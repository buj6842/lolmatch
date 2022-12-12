package com.lolmatch.user.controller

import com.lolmatch.security.enums.TokenType
import com.lolmatch.security.service.CustomUserDetailService
import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.service.UserService
import com.lolmatch.util.exception.ServiceException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class LoginController(
    private val userService: UserService
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/login")
    fun createAuthentication(@RequestBody loginRequest: LoginRequest) :ResponseEntity<Any>{
        val result: MutableMap<String, String?> = HashMap()
        val refreshToken = try {
            userService.login(loginRequest)
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.message)
        }
        val bodyBuilder = ResponseEntity.ok()
        val refreshTokenCookie =
            ResponseCookie.from(TokenType.REFRESH_TOKEN.cookieName, refreshToken).path("/").httpOnly(true).build()
        try {
            val accessToken =
                ResponseCookie.from(TokenType.ACCESS_TOKEN.cookieName, userService.getAccessToken(refreshToken))
                    .path("/").httpOnly(true).build()
            bodyBuilder.header(HttpHeaders.SET_COOKIE, accessToken.toString())
        } catch (exception: ServiceException) {
            log.error("", exception)
        }
        result["code"] = "00000"
        return bodyBuilder.header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString()).body(result)
    }
}

