package com.lolmatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LolmatchApplication

fun main(args: Array<String>) {
    runApplication<LolmatchApplication>(*args)
}
