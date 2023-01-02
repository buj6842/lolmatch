package com.lolmatch.user.repository

import com.lolmatch.user.domain.LeagueInfo
import org.springframework.data.jpa.repository.JpaRepository

interface LeagueInfoRepository: JpaRepository<LeagueInfo, Long> {
}