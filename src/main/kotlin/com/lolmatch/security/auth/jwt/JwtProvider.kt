package com.lolmatch.security.auth.jwt

import com.lolmatch.security.service.CustomUserDetailService
import com.lolmatch.user.dto.TokenData
import com.lolmatch.util.constant.AuthTokenAccess
import com.lolmatch.util.constant.AuthTokenRefresh
import com.lolmatch.util.constant.UserId
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtProvider(
    /* 비밀 키 */
    @Value("\${jwt.secretKey}")
    private val SECRET_KEY : String,

    /* 토큰 유효 시간 */
    @Value("\${jwt.accessExpireTime}")
    private val ACCESS_EXPIRE_TIME : Long,

    /* 토큰 갱신 시간 */
    @Value("\${jwt.refreshExpireTime}")
    private val REFRESH_EXPIRE_TIME : Long,

    private val userDetailService: CustomUserDetailService
) {
    private val accessTokenHeader: String = AuthTokenAccess

    private val refreshTokenHeader: String = AuthTokenRefresh

    // 토큰 생성
    fun createToken(userData : TokenData): String {

        val now = Date()
        return Jwts.builder()
            .setClaims(userData.toMap())
            .setIssuedAt(now)
            .setExpiration(Date(now.time + ACCESS_EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact()
    }

    // 토큰 새로고침
    fun refreshToken(userid: String): String {
        val claims: Claims = Jwts.claims().setSubject(userid);
        claims[UserId] = userid

        val now = Date()
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + REFRESH_EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact()
    }

    /**
     * 토큰에 있는 userSeq 가져오기
     * @param token 토큰
     * @return userSeq, 없을 경우 0
     */
    fun getUserSeq(token: String?) = getUserSeq(getAllClaims(token))

    // 토큰 검증
    fun validation(token: String) : Boolean {
        val claims: Claims = getAllClaims(token)
        val exp: Date = claims.expiration
        return exp.after(Date())
    }

    // 토큰에서 userName 파싱
    fun getUserName(token: String): String {
        val claims: Claims = getAllClaims(token)
        return claims[UserId] as String
    }

    // userid 으로 Authentication 객체 생성
    fun getAuthentication(username: String?): Authentication? {
        val userDetails: UserDetails? = username?.let { userDetailService.loadUserByUsername(it) }
        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails?.authorities)
    }

    fun getUserPk(token: String?): String {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body.subject
    }

    private fun getId(token: String) = Jwts.parser()
        .setSigningKey(SECRET_KEY)
        .parseClaimsJws(token).body.subject

//    fun getUserRole(token: String): UserRole{
//        return UserRole.valueOf(Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body["role"].toString())
//    }

    fun getAccessToken(request: HttpServletRequest): String? {
        return request.getHeader(accessTokenHeader) ?: request.cookies?.find { cookie -> cookie.name == accessTokenHeader }?.value
    }

    fun getRefreshToken(request: HttpServletRequest): String? {
        return request.getHeader(refreshTokenHeader) ?: request.cookies?.find { cookie -> cookie.name == refreshTokenHeader }?.value
    }

    fun validateToken(token: String): Boolean {
        return try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }

    fun getUserSeq(claims: Claims) : Long {
        val userSeq = claims.get(TokenData.USER_SEQ, Any::class.java)
        if (userSeq is Int) {
            return userSeq.toLong()
        } else if (userSeq is Long) {
            return userSeq
        }
        return 0L
    }


    // Claims 조회
    private fun getAllClaims(token: String?): Claims {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .body
    }
}