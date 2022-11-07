package com.lolmatch.security.config

import com.lolmatch.security.auth.jwt.JwtAuthenticationProvider
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val jwtAuthenticationProvider: JwtAuthenticationProvider) {

//    @Bean
//    @Throws(Exception::class)
//    fun filterChain(http: HttpSecurity, jwt: OAuth2ResourceServerProperties.Jwt, tokenService: TokenService): SecurityFilterChain? {
//        return http.csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authorizeRequests()
//            .antMatchers("").hasAuthority(Role.name())
//            .addFilterBefore(JwtAuthenticationFilter(jwtAuthenticationProvider), UsernamePasswordAuthenticationFilter::class.java)
//    }
}