package com.lolmatch.roster.dto

import com.lolmatch.roster.domain.Roster

/**
 * 팀 로스터 생성 DTO
 */
data class RosterCreateDTO(
    private val rosterName: String? = null,
    val teamSeq: Long? = null
) {
    fun toEntity() : Roster {
        return Roster(rosterName)
    }
}