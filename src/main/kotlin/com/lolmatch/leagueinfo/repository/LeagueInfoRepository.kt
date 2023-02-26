package com.lolmatch.leagueinfo.repository

import com.lolmatch.leagueinfo.domain.LeagueInfo
import org.springframework.data.jpa.repository.JpaRepository

interface LeagueInfoRepository: JpaRepository<LeagueInfo, Long> {
}