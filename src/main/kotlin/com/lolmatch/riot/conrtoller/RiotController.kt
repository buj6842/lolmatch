package com.lolmatch.riot.conrtoller

import com.lolmatch.riot.engine.service.RiotApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RiotController(
    private val riotApiService: RiotApiService
) {

    @GetMapping ("/riot/info")
    fun getRiotAuthInfo(summonerName : String) : ResponseEntity<Any> {
        val riotInfo = riotApiService.getRiotInfo(summonerName)
        return ResponseEntity.ok().body(riotInfo)

    }
}