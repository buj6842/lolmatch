package com.lolmatch.common.domain

import com.lolmatch.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

// Riot API 통신을 위한 property 엔티티
@Entity(name = "riotProperty")
@Table(name = "riotProperty")
class RiotPropertyEntity : BaseEntity () {
    @Id
    @Column(name = "property_name", length = 30)
    var propertyName: String? = null

    @Column(name = "property_value1", length = 500)
    var propertyValue1: String? = null

    @Column(name = "property_value2", length = 500)
    var propertyValue2: String? = null
}