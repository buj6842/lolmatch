package com.lolmatch.common.repository

import com.lolmatch.common.domain.RiotPropertyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface RiotPropertyRepository : JpaRepository<RiotPropertyEntity, String> {

    fun findByPropertyName(name : String) : Optional<RiotPropertyEntity>
}