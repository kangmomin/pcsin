package com.example.pcsin.jwt

import io.jsonwebtoken.security.Keys

object JwtProperties {
    const val ACCESS_TYPE = "access"
    const val REFRESH_TYPE = "refresh"
    const val PREFIX = "Bearer "
    const val HEADER = "Authorization"
    const val ACCESS_EXP = 60L * 15 // 15분
    const val REFRESH_EXP = 60L * 60 * 24 * 7 // 1주일
    val SECRET = Keys.hmacShaKeyFor("paowdpawdasdwasd!#@#!@#Asdwa2132@#aowk".toByteArray(Charsets.UTF_8))
}