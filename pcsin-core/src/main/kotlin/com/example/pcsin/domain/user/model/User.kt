package com.example.pcsin.domain.user.model

import java.time.LocalDateTime
import java.util.*

data class User(
    val userId: UUID? = null,
    val email: String? = null,
    val name: String? = null,
    val password: String? = null,
    val salt: String? = null,
    val createdAt: LocalDateTime? = null,
    val lastUpdatedAt: LocalDateTime? = null
) {
}