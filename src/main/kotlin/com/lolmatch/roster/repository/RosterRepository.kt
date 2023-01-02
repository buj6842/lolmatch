package com.lolmatch.roster.repository

import com.lolmatch.roster.dto.Roster
import org.springframework.data.jpa.repository.JpaRepository

interface RosterRepository: JpaRepository<Roster, Long> {
}