package com.lolmatch.user.repository

import com.lolmatch.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
interface UserRepository: JpaRepository<User, Long> , UserCustomRepository {
    @Transactional
    fun findByUserId(userId: String?): Optional<User>

    @Transactional
    fun findByUserSeq(userSeq: Long): User

}