package com.lolmatch.leagueinfo.service

import com.lolmatch.leagueinfo.dto.LeagueInfoCreateDTO
import com.lolmatch.leagueinfo.dto.LeagueInfoDetailDTO
import com.lolmatch.leagueinfo.dto.LeagueInfoUpdateDTO

interface LeagueInfoService {

    fun createLeagueInfo(leagueInfoCreateDTO: LeagueInfoCreateDTO)

    fun updateLeagueInfo(leagueInfoUpdateDTO: LeagueInfoUpdateDTO)

    fun detailLeagueInfo(leagueInfoSeq: Long): LeagueInfoDetailDTO

    fun deleteLeagueInfo(leagueInfoSeq: Long)
}