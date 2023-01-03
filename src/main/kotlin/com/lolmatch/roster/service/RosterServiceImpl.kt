package com.lolmatch.roster.service

import com.lolmatch.roster.domain.Roster
import com.lolmatch.roster.dto.RosterCreateDTO
import com.lolmatch.roster.dto.RosterDetailDTO
import com.lolmatch.roster.dto.RosterUpdateDTO
import com.lolmatch.roster.repository.RosterRepository
import com.lolmatch.team.domain.Team
import org.springframework.transaction.annotation.Transactional

class RosterServiceImpl(
    private val rosterRepository: RosterRepository,
    private val teamRepository: RosterRepository
): RosterService {

    /* 로스터 생성 */
    @Transactional
    override fun createRoster(rosterCreateDTO: RosterCreateDTO) {
        rosterCreateDTO.teamSeq.let {
            val team: Team = teamRepository.findById(it).orElseThrow()
            val roster: Roster = rosterRepository.save(rosterCreateDTO.toEntity())
            team.rosterList?.add(roster)
        }
    }

    /* 로스터 수정 */
    override fun updateRoster(rosterUpdateDTO: RosterUpdateDTO) {
        rosterUpdateDTO.rosterSeq.let {
            val roster: Roster = rosterRepository.findById(it).orElseThrow()
            roster.update(rosterUpdateDTO)
        }
    }

    /* 로스터 상세 */
    override fun detailRoster(rosterSeq: Long): RosterDetailDTO? {
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

    /* 로스터 삭제 */
    override fun deleteRoster(rosterSeq: Long) {
        rosterSeq.let {
            val roster: Roster = rosterRepository.findById(it).orElseThrow()
            roster.delete()
        }
    }
}