package com.lolmatch.security.service

import com.lolmatch.security.auth.jwt.JwtProvider
import com.lolmatch.security.entity.CustomUserDetails
import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.dto.TokenData
import com.lolmatch.user.repository.UserRepository
import com.lolmatch.util.exception.AccessDeniedException
import com.lolmatch.util.exception.ServiceException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class CustomUserDetailService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(userId: String): UserDetails {
        val user = userRepository.findByUserId(userId).orElseGet(null) ?: throw UsernameNotFoundException(userId)
        return CustomUserDetails(user.userId.toString(), user.password.toString())
    }

}