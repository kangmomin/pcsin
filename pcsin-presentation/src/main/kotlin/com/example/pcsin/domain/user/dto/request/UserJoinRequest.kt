package com.example.pcsin.domain.user.dto.request

import com.example.pcsin.domain.user.model.User
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

data class UserJoinRequest(
    @field:NotEmpty
    @field:Min(3, message = "정상적이지 않은 값 입니다.")
    val email: String,
    @field:NotEmpty
    @field:Min(8, message = "비밀번호는 8자 이상이어야 합니다.")
    val password: String,

    @field:NotEmpty
    val name: String
) {
    fun toDomain(): User =
        User(email=this.email,
            password = this.password,
            name = this.name)
}