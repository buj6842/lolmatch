package com.lolmatch.security.enums

enum class TokenType (
    val cookieName: String, val validMilliseconds: Long
) {
    ACCESS_TOKEN("acToken", 1000L * 60 * 15),  // 15분
    REFRESH_TOKEN("cv_rf_tk", 1000L * 60 * 60 * 24 * 14); // 2주
}