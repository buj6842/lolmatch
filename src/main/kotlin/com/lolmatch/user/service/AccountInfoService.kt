package com.lolmatch.user.service

import com.lolmatch.user.domain.AccountInfo
import com.lolmatch.user.domain.User
import com.lolmatch.user.dto.AccountInfoCreateDTO
import com.lolmatch.user.dto.LoginRequest
import com.lolmatch.user.dto.UserCreateDTO

interface AccountInfoService {

    fun createAccountInfo(accountInfoCreateDTO: AccountInfoCreateDTO)

    fun findAccountInfo(accountInfoSeq: Long?): AccountInfo

    fun detailAccountInfo(rosterSeq: Long): AccountInfoDetailDTO
}
