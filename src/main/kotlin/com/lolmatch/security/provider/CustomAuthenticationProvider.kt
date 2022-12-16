package com.lolmatch.security.provider

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider : AuthenticationProvider {
    @Autowired
    private val userDetailsService: UserDetailsService? = null
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val username: String = authentication.name
        val password: String = authentication.credentials.toString()
        val user = userDetailsService!!.loadUserByUsername(username) ?: throw BadCredentialsException("username is not found. username=$username")
        if (!passwordEncoder!!.matches(password, user.password)) {
            throw BadCredentialsException(username)
        }
        if (!user.isEnabled) {
            throw BadCredentialsException(username)
        }
        return UsernamePasswordAuthenticationToken(username, password, user.authorities)
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}