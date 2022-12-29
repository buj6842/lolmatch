package com.lolmatch.team.service.impl

import com.lolmatch.team.dto.TeamCreateDTO
import com.lolmatch.team.dto.TeamUpdateDTO
import com.lolmatch.team.repository.MemberRepository
import com.lolmatch.team.repository.MroleRepository
import com.lolmatch.team.repository.TeamRepository
import com.lolmatch.team.service.TeamService
import com.lolmatch.user.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamServiceImpl(
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository,
    private val userService: UserService,
    private val mroleRepository: MroleRepository
) : TeamService {

    /**
     * 팀 생성
     */
    @Transactional
    override fun createTeam(teamCreateDTO: TeamCreateDTO) {
        val team = teamRepository.save(teamCreateDTO.toEntity())

        for (memberDto in teamCreateDTO.memberList) {
            val mRole = mroleRepository.findByRoleType(memberDto.roleType)
            val user = userService.findUser(memberDto.userSeq)
            var member = memberDto.toEntity(team, user)

            member.mRoles?.add(mRole)
            memberRepository.save(member)
        }
    }

    @Transactional
    override fun updateTeam(teamUpdateDTO: TeamUpdateDTO) {
        val team = teamUpdateDTO.teamSeq?.let { teamRepository.findById(it).orElseThrow() }!!
        team.update(teamUpdateDTO)
    }
}