package com.lolmatch.user.dto

data class AccountInfoDetailDTO(
    val rosterSeq: Long? = null,
    val rosterName: String? = null,
    val top: Long? = null,
    val jungle: Long? = null,
    val mid: Long? = null,
    val ad: Long? = null,
    val support: Long? = null,
    val spare: Long? = null
) {}