package com.lolmatch.team.api

import com.lolmatch.team.dto.TeamCreateDTO
import com.lolmatch.team.service.TeamService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamAPI(
    private val teamService: TeamService
) {
    /**
     * 팀 생성
     */
    @PostMapping("/team")
    fun createTeam(@RequestBody teamCreateDTO: TeamCreateDTO) {
        teamService.createTeam(teamCreateDTO)
    }
}