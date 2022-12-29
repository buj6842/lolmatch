package com.lolmatch.team.dto

import com.lolmatch.team.domain.Member
import com.lolmatch.team.domain.Team
import com.lolmatch.team.enums.MemberRoleType
import com.lolmatch.user.domain.User
/**
 * 멤버 생성 DTO
 */
data class MemberCreateDTO(
    val userSeq: Long,
    val roleType: MemberRoleType
) {
    fun toEntity(
        team: Team? = null,
        user: User? = null
    ): Member {
        return Member(
            mRoleType = roleType,
            team = team,
            user = user
        )
    }
}