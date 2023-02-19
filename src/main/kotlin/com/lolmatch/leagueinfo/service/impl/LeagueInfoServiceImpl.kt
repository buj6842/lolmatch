package com.lolmatch.leagueinfo.service.impl

import com.lolmatch.leagueinfo.domain.LeagueInfo
import com.lolmatch.leagueinfo.dto.LeagueInfoCreateDTO
import com.lolmatch.leagueinfo.dto.LeagueInfoDetailDTO
import com.lolmatch.leagueinfo.dto.LeagueInfoUpdateDTO
import com.lolmatch.leagueinfo.repository.LeagueInfoRepository
import com.lolmatch.leagueinfo.service.LeagueInfoService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LeagueInfoServiceImpl(
    private val leagueInfoRepository: LeagueInfoRepository
): LeagueInfoService {

    /* 생성 */
    @Transactional
    override fun createLeagueInfo(leagueInfoCreateDTO: LeagueInfoCreateDTO) {
        leagueInfoRepository.save(leagueInfoCreateDTO.toEntity())
    }

    /* 수정 */
    @Transactional
    override fun updateLeagueInfo(leagueInfoUpdateDTO: LeagueInfoUpdateDTO) {
        leagueInfoUpdateDTO.leagueInfoSeq.let {
            val leagueInfo: LeagueInfo = leagueInfoRepository.findById(it).orElseThrow()
            leagueInfo.update(leagueInfoUpdateDTO)
        }
    }

    /* 상세 */
    @Transactional
    override fun detailLeagueInfo(leagueInfoSeq: Long): LeagueInfoDetailDTO {
        leagueInfoSeq.let {
            val leagueInfo: LeagueInfo = leagueInfoRepository.findById(leagueInfoSeq).orElseThrow()
            return LeagueInfoDetailDTO(
                leagueInfo.leagueInfoSeq,
                leagueInfo.leagueId,
                leagueInfo.queueType,
                leagueInfo.tier,
                leagueInfo.rank,
                leagueInfo.leaguePoints,
                leagueInfo.wins,
                leagueInfo.losses,
                leagueInfo.hotStreak,
                leagueInfo.veteran,
                leagueInfo.freshBlood,
                leagueInfo.inactive
            )
        }
    }

    /* 삭제 */
    @Transactional
    override fun deleteLeagueInfo(leagueInfoSeq: Long) {
        leagueInfoSeq.let {
            val leagueInfo: LeagueInfo = leagueInfoRepository.findById(it).orElseThrow()
            leagueInfo.delete()
        }
    }
}