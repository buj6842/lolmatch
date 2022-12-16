package com.lolmatch.user.service.impl

import com.lolmatch.security.auth.jwt.JwtProvider
import com.lolmatch.user.domain.User
import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.dto.TokenData
import com.lolmatch.user.dto.UserCreateDTO
import com.lolmatch.user.repository.UserRepository
import com.lolmatch.user.service.UserService
import com.lolmatch.util.exception.AccessDeniedException
import com.lolmatch.util.exception.ServiceException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception
import java.security.PrivateKey
import java.util.Optional
import kotlin.jvm.Throws

@Service
class UserServiceImpl (
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider
        ) : UserService {


    @Transactional
    override fun createUser(userCreateDTO: UserCreateDTO) {
        userRepository.save(userCreateDTO.toEntity())
    }

    override fun findUser(userSeq: Long?): User {
        return userSeq?.let { userRepository.findById(it).orElseThrow() }!!
    }

    override fun getAccessToken(refreshToken: String?): String {
        val userPk = jwtProvider.getUserSeq(refreshToken)
        val userEntity = findUser(userPk)
        if(refreshToken != userEntity.refreshToken) {
            throw ServiceException("이미 새롭게 로그인된 토큰입니다.")
        }

        val accessData = TokenData(
            userSeq = userEntity.userSeq,
            userId = userEntity.userId,
            userType = userEntity.userType
        )
        val accessToken = jwtProvider.createToken(accessData)
        SecurityContextHolder.getContext().authentication = jwtProvider.getAuthentication(userEntity.userId)
        return accessToken

    }

    @Throws(ServiceException::class)
    override fun login(loginRequest: LoginRequest) : String {
        //로그인 request 를 통해 객체를
        val user = userRepository.findByUserId(loginRequest.id).orElseThrow()
        if(!BCrypt.checkpw(loginRequest.password?:"",user.password))
            throw AccessDeniedException("비밀번호가 일치하지 않습니다.")
        val token = jwtProvider.createToken(TokenData(user.userSeq,user.userId,user.userType))
        user.refreshToken = token
        return token
    }

    override fun duplicateCheck(userId: String): Boolean =
        userRepository.findByUserId(userId).isPresent

}