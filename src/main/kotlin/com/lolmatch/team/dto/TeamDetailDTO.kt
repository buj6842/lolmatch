package com.lolmatch.team.dto

data class TeamDetailDTO(
    var teamSeq: Long? = null,
    var teamName: String? = null,
    var memberList: List<MemberDetailDTO>? = null
) {}