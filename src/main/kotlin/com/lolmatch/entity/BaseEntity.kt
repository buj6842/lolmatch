package com.lolmatch.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @CreatedDate
    @Column @NotNull
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column @NotNull
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @Column
    var delYn: Boolean = false
}