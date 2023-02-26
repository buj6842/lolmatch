package com.lolmatch.redis.service.impl

import com.lolmatch.redis.service.RedisService
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisService(
    private val redisTemplate: RedisTemplate<String, Any>
): RedisService {

    override fun save(key: String, value: Any) {
        redisTemplate.opsForValue().set(key, value)
    }

    override fun get(key: String): Any {
        return redisTemplate.opsForValue().get(key)!!
    }

    override fun increment(key: String) {
        redisTemplate.opsForValue().increment(key)
    }

    override fun decrement(key: String) {
        redisTemplate.opsForValue().decrement(key)
    }
}