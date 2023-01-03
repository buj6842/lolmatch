package com.lolmatch.riot.engine

import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

enum class RiotApiResponseCode(val state: String) {
    DEFAULT("000"), SUCCESS("200"), PARSING_ERROR("997"), TIMEOUT("998"), PROPERTY_ERROR("999");

    companion object {
        private val states = Arrays.stream(values())
            .collect(Collectors.toMap(RiotApiResponseCode::state, Function.identity()))

        fun findByState(state: String): RiotApiResponseCode {
            return states[state] ?: DEFAULT
        }
    }
}