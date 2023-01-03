package com.lolmatch.accountinfo.repository

import com.lolmatch.accountinfo.domain.AccountInfo
import org.springframework.data.jpa.repository.JpaRepository

interface AccountInfoRepository: JpaRepository<AccountInfo, Long> {
}