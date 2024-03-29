package com.lolmatch.roster.service

import com.lolmatch.roster.dto.RosterCreateDTO
import com.lolmatch.roster.dto.RosterDetailDTO
import com.lolmatch.roster.dto.RosterUpdateDTO

interface RosterService {

    fun createRoster(rosterCreateDTO: RosterCreateDTO)

    fun updateRoster(rosterUpdateDTO: RosterUpdateDTO)

    fun detailRoster(rosterSeq: Long): RosterDetailDTO?

    fun deleteRoster(rosterSeq: Long)
}
