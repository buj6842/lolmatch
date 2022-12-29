package com.lolmatch.team.service.impl

import com.lolmatch.team.domain.Member
import com.lolmatch.team.dto.MemberDetailDTO
import com.lolmatch.team.dto.TeamCreateDTO
import com.lolmatch.team.dto.TeamDetailDTO
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

    /**
     * 팀 수정 (팀명만 수정)
     */
    @Transactional
    override fun updateTeam(teamUpdateDTO: TeamUpdateDTO) {
        val team = teamUpdateDTO.teamSeq?.let { teamRepository.findById(it).orElseThrow() }!!
        team.update(teamUpdateDTO)
    }

    /**
     * 팀 단일 조회
     */
    @Transactional
    override fun detailTeam(teamSeq: Long): TeamDetailDTO {
        val team = teamSeq?.let { teamRepository.findById(it).orElseThrow() }!!
        return TeamDetailDTO(
            team.teamSeq,
            team.teamName,
            team?.memberList?.map { mb: Member -> MemberDetailDTO(mb.mRoleType, mb.memberSeq) }
        )
    }
}