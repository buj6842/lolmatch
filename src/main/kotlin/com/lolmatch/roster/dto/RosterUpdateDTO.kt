package com.lolmatch.roster.dto

/**
 * 팀 로스터 수정 DTO
 */
data class RosterUpdateDTO(
    val rosterSeq: Long,
    var rosterName: String? = null,
    var top: Long? = null,
    var jungle: Long? = null,
    var mid: Long? = null,
    var ad: Long? = null,
    var support: Long? = null,
    var spare: Long? = null
)