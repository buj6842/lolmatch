package com.lolmatch.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.lolmatch.entity.type.UserRoleType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table


@Entity
@Table(name = "tbl_role")
class Role : BaseEntity() {
    val roleType: UserRoleType? = null

    @Id
    @Column(name = "id")
    private val id: Long = 0L

    @OneToOne(mappedBy = "role", fetch = FetchType.LAZY)
    @JsonIgnore
    private val user: User? = null
}