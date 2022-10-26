package com.lolmatch.security.auth.jwt

import com.lolmatch.security.service.CustomUserDetailService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtAuthenticationProvider(
    @Value("\${jwt.secretKey}")
    private val SECRET_KEY : String,

    @Value("\${jwt.accessExpireTime}")
    private val ACCESS_EXPIRE_TIME : Long,

    @Value("\${jwt.refreshExpireTime}")
    private val REFRESH_EXPIRE_TIME : Long,

    private val userDetailService: CustomUserDetailService
) {
    private val accessTokenHeader: String = "X-AUTH-TOKEN-ACCESS"

    private val refreshTokenHeader: String = "X-AUTH-TOKEN-REFRESH"

    // 토큰 생성
    fun createToken(username: String): String {
        val claims: Claims = Jwts.claims().setSubject(username);
        claims["username"] = username

        val now = Date()
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + ACCESS_EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact()
    }

    // 토큰 새로고침
    fun refreshToken(username: String): String {
        val claims: Claims = Jwts.claims().setSubject(username);
        claims["username"] = username

        val now = Date()
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + REFRESH_EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact()
    }

    // 토큰 검증
    fun validation(token: String) : Boolean {
        val claims: Claims = getAllClaims(token)
        val exp: Date = claims.expiration
        return exp.after(Date())
    }

    // 토큰에서 userName 파싱
    fun getUserName(token: String): String {
        val claims: Claims = getAllClaims(token)
        return claims["username"] as String
    }

    // userName으로 Authentication 객체 생성
    fun getAuthentication(username: String): Authentication {
        val userDetails: UserDetails = userDetailService.loadUserByUsername(username)

        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    fun getUserPk(token: String): String {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body.subject
    }

//    fun getUserRole(token: String): UserRole{
//        return UserRole.valueOf(Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body["role"].toString())
//    }

    fun getAccessToken(request: HttpServletRequest): String? {
        return request.getHeader(accessTokenHeader)
            ?: request.cookies?.find { cookie -> cookie.name == accessTokenHeader }?.value
    }

    fun getRefreshToken(request: HttpServletRequest): String? {
        return request.getHeader(refreshTokenHeader)
            ?: request.cookies?.find { cookie -> cookie.name == refreshTokenHeader }?.value
    }

    fun validateToken(token: String): Boolean {
        return try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }

    // Claims 조회
    private fun getAllClaims(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .body
    }
}