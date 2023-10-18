package com.example.pcsin.domain.user.service

import com.example.pcsin.common.annotation.Service
import com.example.pcsin.domain.user.exception.UserAlreadyExistException
import com.example.pcsin.domain.user.model.User
import com.example.pcsin.domain.user.spi.CommandUserPort
import com.example.pcsin.domain.user.usecase.CommandUserUseCase

@Service
open class CommandUserService(
    private val commandUserPort: CommandUserPort
): CommandUserUseCase {
    override fun joinUser(user: User) {
        if (commandUserPort.createUserWhenNotExist(user) == null) throw UserAlreadyExistException()
    }
}