package com.lolmatch.accountinfo.service.impl

import com.lolmatch.accountinfo.domain.AccountInfo
import com.lolmatch.accountinfo.dto.AccountInfoCreateDTO
import com.lolmatch.accountinfo.dto.AccountInfoDetailDTO
import com.lolmatch.accountinfo.dto.AccountInfoUpdateDTO
import com.lolmatch.accountinfo.repository.AccountInfoRepository
import com.lolmatch.accountinfo.service.AccountInfoService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountInfoServiceImpl(
    private val accountInfoRepository: AccountInfoRepository
): AccountInfoService {

    /* 생성 */
    @Transactional
    override fun createAccountInfo(accountInfoCreateDTO: AccountInfoCreateDTO) {
        accountInfoRepository.save(accountInfoCreateDTO.toEntity())
    }

    /* 수정 */
    @Transactional
    override fun updateAccountInfo(accountInfoUpdateDTO: AccountInfoUpdateDTO) {
        accountInfoUpdateDTO.accountInfoSeq.let {
            val accountInfo: AccountInfo = accountInfoRepository.findById(it).orElseThrow()
            accountInfo.update(accountInfoUpdateDTO)
        }
    }

    /* 상세 */
    @Transactional
    override fun detailAccountInfo(accountInfoSeq: Long): AccountInfoDetailDTO {
        accountInfoSeq.let {
            val accountInfo: AccountInfo = accountInfoRepository.findById(accountInfoSeq).orElseThrow()
            return AccountInfoDetailDTO(
                accountInfo.accountInfoSeq,
                accountInfo.riotUserKey,
                accountInfo.encryptAccountId,
                accountInfo.profileIconId,
                accountInfo.revisionDate,
                accountInfo.nickname,
                accountInfo.puuid,
                accountInfo.summonerLevel,
                accountInfo.leagueInfo
            )
        }
    }

    /* 삭제 */
    @Transactional
    override fun deleteAccountInfo(accountInfoSeq: Long) {
        accountInfoSeq.let {
            val accountInfo: AccountInfo = accountInfoRepository.findById(it).orElseThrow()
            accountInfo.delete()
        }
    }
}