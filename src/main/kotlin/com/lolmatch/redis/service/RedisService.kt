package com.lolmatch.redis.service

interface RedisService {

    fun save(key: String, value: Any)

    fun get(key: String): Any

    fun increment(key: String)

    fun decrement(key: String)
}