package com.example.pcsin.domain.user.dto

data class JwtTokens (
    val accessToken: String,
    val refreshToken: String,
)
