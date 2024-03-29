package com.lolmatch.security.service

import com.lolmatch.security.entity.CustomUserDetails
import com.lolmatch.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(userId: String): UserDetails {
        val user = userRepository.findByUserId(userId).orElseGet(null) ?: throw UsernameNotFoundException(userId)
        return CustomUserDetails(user.userId.toString(), user.password.toString())
    }

}