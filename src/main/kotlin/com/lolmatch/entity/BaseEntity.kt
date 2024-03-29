package com.lolmatch.entity

import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @CreatedDate
    @Column
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @Column
    var delYn: Boolean = false
}