package com.example.pcsin.common.entity

import jakarta.persistence.Column
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime
import java.time.ZoneId


open class BasicTimeEntity {

    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @PrePersist
    fun preSave() {
        this.createdAt = getSeoulDateTime()
        this.updatedAt = getSeoulDateTime()
    }

    @PreUpdate
    fun preUpdate() {
        this.updatedAt = getSeoulDateTime()
    }

    private fun getSeoulDateTime(): LocalDateTime {
        val now = LocalDateTime.now()
        val seoulZone = ZoneId.of("Asia/Seoul")
        return now.atZone(seoulZone).toLocalDateTime()
    }
}