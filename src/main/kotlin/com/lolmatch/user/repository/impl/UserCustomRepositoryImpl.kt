package com.lolmatch.user.repository.impl

import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.dto.UserDetailDTO
import com.lolmatch.user.repository.UserCustomRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.lolmatch.user.domain.QUser.user
import com.lolmatch.user.dto.LoginResponseDTO
import com.querydsl.core.types.dsl.BooleanExpression


@Repository
class UserCustomRepositoryImpl(
    private var queryFactory: JPAQueryFactory
) : UserCustomRepository {

    override fun getUserByUserName(userName: String): String {
     return "a"
    }

    override fun getUserDetailById(loginRequest: LoginRequest): LoginResponseDTO? {
        return queryFactory.select(Projections.bean(LoginResponseDTO::class.java,
            user.userId,
            user.password,
            user.userType
            )).from(user).where(eqId(loginRequest.id)).fetchOne()
    }
    private fun eqId(id : String?) : BooleanExpression? =
        if(id != null) user.userId.eq(id)
        else null
}