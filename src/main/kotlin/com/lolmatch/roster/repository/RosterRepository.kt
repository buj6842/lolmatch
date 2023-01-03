package com.lolmatch.roster.repository

import com.lolmatch.roster.domain.Roster
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RosterRepository: JpaRepository<Roster, Long> {
}