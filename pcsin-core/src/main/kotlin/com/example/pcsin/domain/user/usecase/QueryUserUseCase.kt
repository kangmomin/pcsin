package com.example.pcsin.domain.user.usecase

import com.example.pcsin.common.annotation.ReadOnlyUseCase
import com.example.pcsin.domain.user.dto.JwtTokens
import com.example.pcsin.domain.user.model.User

@ReadOnlyUseCase
interface QueryUserUseCase {
    fun login(loginRequest: User): JwtTokens
}