package com.example.pcsin.domain.user.model

import java.time.LocalDateTime

data class User(
    val userId: Int,
    val email: String,
    val name: String,
    val password: String,
    val salt: String,
    val createdAt: LocalDateTime,
    val lastUpdatedAt: LocalDateTime
) {
}