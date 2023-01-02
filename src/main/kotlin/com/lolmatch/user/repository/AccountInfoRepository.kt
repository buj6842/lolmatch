package com.lolmatch.user.repository

import com.lolmatch.user.domain.AccountInfo
import org.springframework.data.jpa.repository.JpaRepository

interface AccountInfoRepository: JpaRepository<AccountInfo, Long> {
}