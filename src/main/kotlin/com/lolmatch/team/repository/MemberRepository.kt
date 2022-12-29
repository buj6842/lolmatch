package com.lolmatch.team.repository

import com.lolmatch.team.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

interface MemberRepository: JpaRepository<Member, Long> {

    @Transactional
    fun findByMemberSeq(memberSeq: Long?): Member
}