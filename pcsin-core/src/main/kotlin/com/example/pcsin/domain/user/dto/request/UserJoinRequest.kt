package com.example.pcsin.domain.user.dto.request

import com.example.pcsin.domain.user.model.User

data class UserJoinRequest(
    val name: String,
    val email: String,
    val password: String,
) {
    fun toDomain(): User =
        User(email=this.email,
            password = this.password,
            name = this.name)
}