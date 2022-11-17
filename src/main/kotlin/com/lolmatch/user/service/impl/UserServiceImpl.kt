package com.lolmatch.user.service.impl

import com.lolmatch.user.dto.UserCreateDTO
import com.lolmatch.user.repository.UserRepository
import com.lolmatch.user.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
        ) : UserService {
    @Transactional
    override fun createUser(request: UserCreateDTO) {
        userRepository.save(request.toEntity())
    }
}