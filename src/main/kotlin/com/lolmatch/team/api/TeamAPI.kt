package com.lolmatch.team.api

import com.lolmatch.team.dto.TeamCreateDTO
import com.lolmatch.team.dto.TeamDetailDTO
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

    /**
     * 팀 단일 조회
     */
    @GetMapping("/team/{teamSeq}")
    fun detailTeam(@PathVariable teamSeq: Long): TeamDetailDTO {
        return teamService.detailTeam(teamSeq)
    }

    /**
     * 팀 삭제
     */
    @DeleteMapping("/team/{teamSeq}")
    fun deleteTeam(@PathVariable teamSeq: Long) {
        return teamService.deleteTeam(teamSeq)
    }
}