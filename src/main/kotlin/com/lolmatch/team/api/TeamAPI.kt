package com.lolmatch.team.api

import com.lolmatch.team.dto.TeamCreateDTO
import com.lolmatch.team.dto.TeamUpdateDTO
import com.lolmatch.team.service.TeamService
import org.springframework.web.bind.annotation.*

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

    /**
     * 팀 수정 (팀명만 수정)
     */
    @PutMapping("/team")
    fun updateTeam(@RequestBody teamUpdateDTO: TeamUpdateDTO) {
        teamService.updateTeam(teamUpdateDTO)
    }
}