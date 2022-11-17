package com.lolmatch.user.repository.impl

import com.lolmatch.user.dto.UserDetailDTO
import com.lolmatch.user.repository.UserCustomRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext



@Repository
class UserCustomRepositoryImpl : UserCustomRepository {

    override fun getUserByUserName(userName: String): String {
     return "a"
    }
}