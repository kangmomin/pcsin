package com.example.pcsin.domain.user.spi

import com.example.pcsin.domain.user.model.User

interface CommandUserPort {
    fun createUserWhenNotExist(user: User): User?
}