package com.lolmatch.security.auth

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class LolMatchAuthentication(principal: Any?, credentials: Any?, authorities: Collection<GrantedAuthority?>?) :
    UsernamePasswordAuthenticationToken(
        principal,
        credentials,
        authorities
    ) {
    var userSeq: Long = 0

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + userSeq.hashCode()
        return result
    }
}