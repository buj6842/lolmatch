package com.lolmatch.team.service

import com.lolmatch.team.dto.TeamCreateDTO

interface TeamService {
    fun createTeam(teamCreateDTO: TeamCreateDTO)
}