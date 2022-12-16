package com.lolmatch.util.exception

class AccessDeniedException constructor(message: String = "잘못된 접근입니다.") : ServiceException(
    message
) {
    companion object {
        fun invalidSecurity(): AccessDeniedException {
            return AccessDeniedException("잘못된 권한입니다.")
        }
    }
}