package com.example.pcsin.domain.user.dto.request

import com.example.pcsin.domain.user.model.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class UserJoinRequest(
    @field:NotEmpty(message = "이메일은 필수 입력 값 입니다.")
    @field:Email(message = "이메일 형식에 맞지 않습니다.")
    val email: String,

    @field:NotEmpty(message = "비밀번호는 필수 입력 값 입니다.")
    @field:Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    val password: String,

    @field:NotEmpty(message = "이름은 필수 입력 값 입니다.")
    @field:Size(min = 2, message = "이름은 2자 이상이어야 합니다.")
    val name: String
) {
    fun toDomain(): User =
        User(email = this.email,
            password = this.password,
            name = this.name)
}