package com.example.pcsin.common.security

import com.example.pcsin.common.annotation.Util

@Util
interface JwtProvider {
    fun generateAccessToken(email: String): String
    fun generateRefreshToken(email: String): String

    fun resolveAccessToken(token: String): String?
    fun resolveRefreshToken(token: String): String?
}