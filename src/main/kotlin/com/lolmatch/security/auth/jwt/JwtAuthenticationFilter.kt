package com.lolmatch.security.auth.jwt

import javax.servlet.http.HttpServletRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.AntPathMatcher
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class JwtAuthenticationFilter(
    private val jwtAuthenticationProvider: JwtAuthenticationProvider
): GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req = request as HttpServletRequest
        val token: String? = jwtAuthenticationProvider.getAccessToken(request)
        if (token != null && jwtAuthenticationProvider.validateToken(token)) {
            val authentication = jwtAuthenticationProvider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = authentication
        }
        chain?.doFilter(request, response)
    }

}