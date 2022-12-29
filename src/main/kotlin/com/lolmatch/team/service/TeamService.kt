package com.lolmatch.team.service

import com.lolmatch.team.dto.TeamCreateDTO
import com.lolmatch.team.dto.TeamDetailDTO
import com.lolmatch.team.dto.TeamUpdateDTO

interface TeamService {
    fun createTeam(teamCreateDTO: TeamCreateDTO)

    fun updateTeam(teamUpdateDTO: TeamUpdateDTO)

    fun detailTeam(teamSeq: Long): TeamDetailDTO
}