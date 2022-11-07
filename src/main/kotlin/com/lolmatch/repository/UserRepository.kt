package com.lolmatch.repository

import com.lolmatch.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByUserId(userId: String): Optional<User>
}