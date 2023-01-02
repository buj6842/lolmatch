package com.lolmatch.roster.dto

/**
 * 팀 로스터 생성 DTO
 */
data class RosterCreateDTO(
    var rosterName: String? = null
) {
    fun toEntity() : Roster {
        return Roster(rosterName)
    }
}