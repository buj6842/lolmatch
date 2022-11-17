package com.lolmatch.security.config

import com.lolmatch.security.auth.jwt.JwtAuthenticationProvider
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val jwtAuthenticationProvider: JwtAuthenticationProvider) :
    WebSecurityConfigurerAdapter()
{
    companion object {
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.cors().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .and()
            .formLogin().disable()

    }
}