package com.lolmatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@EntityScan("com.lolmatch.*")
@EnableJpaRepositories("com.lolmatch.*")
@EnableAsync
@ComponentScan("com.lolmatch.*")
class LolmatchApplication{
}

fun main(args: Array<String>) {
    runApplication<LolmatchApplication>(*args)
}
