package com.lolmatch.repository

import com.lolmatch.user.domain.AccountInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface AccountInfoRepository: JpaRepository<AccountInfo, String>, QuerydslPredicateExecutor<AccountInfo> {
}