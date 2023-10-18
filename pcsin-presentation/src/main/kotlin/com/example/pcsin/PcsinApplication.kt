package com.example.pcsin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class PcsinApplication
fun main(args: Array<String>) {
    runApplication<PcsinApplication>(*args)
}