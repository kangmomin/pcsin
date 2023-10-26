package com.example.pcsin.domain.user.dto.request

import com.example.pcsin.domain.user.model.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

data class LoginRequest (
    @NotEmpty(message = "이메일이 입력되지 않았습니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    val email: String,
    @NotEmpty(message = "비밀번호가 입력되지 않았습니다.")
    @Min(8, message = "비밀번호는 8자 이상이어야 합니다.")
    val password: String,


) {
    fun toDomain(): User =
        User(
            email = this.email,
            password = this.password
        )
}
