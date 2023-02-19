package com.lolmatch.roster.service.impl

import com.lolmatch.roster.domain.Roster
import com.lolmatch.roster.dto.RosterCreateDTO
import com.lolmatch.roster.dto.RosterDetailDTO
import com.lolmatch.roster.dto.RosterUpdateDTO
import com.lolmatch.roster.repository.RosterRepository
import com.lolmatch.roster.service.RosterService
import com.lolmatch.team.domain.Team
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RosterServiceImpl(
    private val rosterRepository: RosterRepository,
    private val teamRepository: RosterRepository
): RosterService {

    /* 생성 */
    @Transactional
    override fun createRoster(rosterCreateDTO: RosterCreateDTO) {
        rosterCreateDTO.teamSeq.let {
            val team: Team = Team()
//            val team: Team = teamRepository.findById(it).orElseThrow()

            val roster: Roster = rosterRepository.save(rosterCreateDTO.toEntity())
            roster.team = team

            team.rosterList?.add(roster)
        } ?: run {
            throw IllegalArgumentException()
        }
    }

    /* 수정 */
    @Transactional
    override fun updateRoster(rosterUpdateDTO: RosterUpdateDTO) {
        rosterUpdateDTO.rosterSeq.let {
            val roster: Roster = rosterRepository.findById(it).orElseThrow()
            roster.update(rosterUpdateDTO)
        }
    }

    /* 상세 */
    @Transactional
    override fun detailRoster(rosterSeq: Long): RosterDetailDTO {
        rosterSeq.let {
            val roster: Roster = rosterRepository.findById(it).orElseThrow()
            return RosterDetailDTO(
                roster.rosterSeq,
                roster.rosterName,
                roster.top,
                roster.jungle,
                roster.mid,
                roster.ad,
                roster.support,
                roster.spare
            )
        }
    }

    /* 삭제 */
    @Transactional
    override fun deleteRoster(rosterSeq: Long) {
        rosterSeq.let {
            val roster: Roster = rosterRepository.findById(it).orElseThrow()
            roster.delete()
        }
    }
}