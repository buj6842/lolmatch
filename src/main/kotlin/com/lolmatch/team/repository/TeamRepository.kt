package com.lolmatch.team.repository

import com.lolmatch.team.domain.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long> {
}