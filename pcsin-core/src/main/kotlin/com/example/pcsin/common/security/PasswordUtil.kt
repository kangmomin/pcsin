package com.example.pcsin.common.security

import com.example.pcsin.common.annotation.Util

@Util
interface PasswordUtil {
    fun encode(password: String, salt: String): String
    fun match(rawPassword: String, salt: String, encodedPassword: String): Boolean
    fun generateSalt(): String
}