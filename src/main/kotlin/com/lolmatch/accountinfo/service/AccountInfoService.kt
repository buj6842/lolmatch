package com.lolmatch.accountinfo.service

import com.lolmatch.accountinfo.dto.AccountInfoCreateDTO
import com.lolmatch.accountinfo.dto.AccountInfoDetailDTO
import com.lolmatch.accountinfo.dto.AccountInfoUpdateDTO

interface AccountInfoService {

    fun createAccountInfo(accountInfoCreateDTO: AccountInfoCreateDTO)

    fun updateAccountInfo(accountInfoUpdateDTO: AccountInfoUpdateDTO)

    fun detailAccountInfo(accountInfoSeq: Long): AccountInfoDetailDTO

    fun deleteAccountInfo(accountInfoSeq: Long)
}