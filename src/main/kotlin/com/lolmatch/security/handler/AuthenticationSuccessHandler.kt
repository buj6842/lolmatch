package com.lolmatch.security.handler


import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationSuccessHandler : AuthenticationSuccessHandler {
    @Throws(IOException::class)
    override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse, authentication: Authentication?) {
        SecurityContextHolder.getContext().authentication = authentication
        response.sendRedirect("/")
    }
}