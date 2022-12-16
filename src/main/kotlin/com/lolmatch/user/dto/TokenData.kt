package com.lolmatch.user.dto

import com.lolmatch.user.enums.UserRoleType

class TokenData(
    val userSeq: Long? = null,
    var userId: String? = null,
    var userType: UserRoleType? = null
) {
    fun toMap(): Map<String, Any?> {
        val hashMap = HashMap<String, Any?>()
        userId?.let {
            hashMap[USER_ID] = it
        }
        userType?.let {
            hashMap[USER_TYPE] = it
        }
        userSeq?.let {
            hashMap[USER_SEQ] = it
        }
        return hashMap
    }
    companion object {
        const val USER_SEQ = "userSeq"
        const val USER_ID = "userId"
        const val USER_TYPE = "userType"
    }
}