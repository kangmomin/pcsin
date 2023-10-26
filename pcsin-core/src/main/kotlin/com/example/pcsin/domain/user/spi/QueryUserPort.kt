package com.example.pcsin.domain.user.spi

import com.example.pcsin.domain.user.dto.UserLoginInfoDto
import com.example.pcsin.domain.user.model.User

interface QueryUserPort {
    fun loginInfo(email: String): UserLoginInfoDto
    fun findByEmail(email: String): User
}