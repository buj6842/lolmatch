package com.lolmatch.team.dto

import com.lolmatch.team.enums.MemberRoleType

data class MemberDetailDTO(
    var mRoleType: MemberRoleType? = null,
    var memberSeq: Long? = null
) {
}