package com.example.pcsin.domain.user.service

import com.example.pcsin.common.annotation.Service
import com.example.pcsin.common.security.PasswordUtil
import com.example.pcsin.domain.user.exception.UserAlreadyExistException
import com.example.pcsin.domain.user.model.User
import com.example.pcsin.domain.user.spi.CommandUserPort
import com.example.pcsin.domain.user.usecase.CommandUserUseCase

@Service
open class CommandUserService(
    private val commandUserPort: CommandUserPort,
    private val passwordUtil: PasswordUtil
): CommandUserUseCase {
    override fun joinUser(user: User) {
        user.salt = passwordUtil.generateSalt()
        user.password = passwordUtil.encode(user.password!!, user.salt!!)

        if (commandUserPort.createUserWhenNotExist(user) == null) throw UserAlreadyExistException()
    }
}