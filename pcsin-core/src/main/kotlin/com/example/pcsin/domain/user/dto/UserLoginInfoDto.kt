package com.example.pcsin.domain.user.dto

data class UserLoginInfoDto (
    val email: String,
    val password: String,
    val salt: String
)