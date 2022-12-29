package com.lolmatch.common.service.impl

import com.lolmatch.common.domain.RiotPropertyEntity
import com.lolmatch.common.enums.RiotProperty
import com.lolmatch.common.property.RiotApiProperty
import com.lolmatch.common.repository.RiotPropertyRepository
import com.lolmatch.common.service.RiotPropertyService
import com.lolmatch.riot.engine.ApiEngine
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class RiotPropertyServiceImpl(
    private val apiEngine: ApiEngine,
    private val riotPropertyRepository: RiotPropertyRepository
) : RiotPropertyService {

    @PostConstruct
    private fun init() {
        apiEngine.init(riotApiProperty)
    }

    override val riotApiProperty: RiotApiProperty?
        get() = riotPropertyRepository.findByPropertyName(RiotProperty.RIOT_PROPERTY.name).orElse(null).let {
            RiotApiProperty(it)
        }

    override fun updateRiotApiProperty(apiKey: String?) {
        var riotPropertyEntity = riotPropertyRepository.findById(RiotProperty.RIOT_PROPERTY.name).orElseGet {
            RiotPropertyEntity().apply {
                propertyName = RiotProperty.RIOT_PROPERTY.name
                propertyValue1 = "https://kr.api.riotgames.com"
            }
        }.apply {
            propertyValue2 = apiKey
        }
        riotPropertyEntity = riotPropertyRepository.save(riotPropertyEntity)
        apiEngine.updateApiProperty(RiotApiProperty(riotPropertyEntity))
    }
}