package com.lolmatch.riot.engine.model

data class Rune(
    var perkIds: List<Long> = emptyList(),
    var perkStyle: Long? = null,
    var perkSubStyle: Long? = null
)