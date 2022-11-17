//package com.lolmatch.security.service
//
//import com.lolmatch.user.domain.User
//import com.lolmatch.security.entity.CustomUserDetails
//import com.lolmatch.user.repository.UserRepository
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.stereotype.Service
//
//@Service
//class CustomUserDetailService(private val userRepository: UserRepository): UserDetailsService {
//    override fun loadUserByUsername(username: String): UserDetails {
//        val user: User = userRepository.findByUserId(username).orElseGet(null) ?: throw UsernameNotFoundException(username)
//
//        return CustomUserDetails(user.userId, user.password, user.roleType.getValue())
//    }
//}