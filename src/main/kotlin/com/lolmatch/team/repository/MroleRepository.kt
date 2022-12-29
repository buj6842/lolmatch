package com.lolmatch.team.repository

import com.lolmatch.team.domain.Mrole
import com.lolmatch.team.enums.MemberRoleType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

interface MroleRepository: JpaRepository<Mrole, Long> {
    @Transactional
    fun findByRoleType(roleType: MemberRoleType?): Mrole
}