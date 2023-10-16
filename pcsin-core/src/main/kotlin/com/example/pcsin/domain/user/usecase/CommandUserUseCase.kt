package com.example.pcsin.domain.user.usecase

import com.example.pcsin.common.annotation.UseCase
import com.example.pcsin.domain.user.model.User

@UseCase
interface CommandUserUseCase {
    fun joinUser(user: User)
}