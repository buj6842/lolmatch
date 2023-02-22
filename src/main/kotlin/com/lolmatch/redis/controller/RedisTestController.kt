package com.lolmatch.redis.controller

import com.lolmatch.redis.service.RedisService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RedisTestController(
    private val redisService: RedisService
) {

    private val key = "test"

    @PostMapping("/redis/save")
    fun save() {
        redisService.save(key, "23619819")
    }

    @PostMapping("/redis/get")
    fun get(): String {
        return redisService.get(key).toString()
    }
}