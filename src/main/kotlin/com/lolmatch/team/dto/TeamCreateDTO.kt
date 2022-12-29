package com.lolmatch.team.dto

import com.lolmatch.team.domain.Team

/**
 * 팀 생성 DTO
 */
data class TeamCreateDTO(
    val teamName: String,
    val memberList: List<MemberCreateDTO>
) {

    fun toEntity(): Team {
        return Team(teamName = teamName)
    }
}