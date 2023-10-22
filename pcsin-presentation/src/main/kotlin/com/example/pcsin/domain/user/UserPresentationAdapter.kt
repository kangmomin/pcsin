package com.example.pcsin.domain.user

import com.example.pcsin.domain.user.dto.request.UserJoinRequest
import com.example.pcsin.domain.user.usecase.CommandUserUseCase
import com.example.pcsin.global.dto.response.BasicResponse
import com.example.pcsin.global.dto.response.BasicResponseDto
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserPresentationAdapter(
    private val cmdUseCase: CommandUserUseCase
) {

    @PostMapping("/join")
    fun createUserWhenNotExist(@RequestBody @Valid joinDto: UserJoinRequest): ResponseEntity<Any?> =
        cmdUseCase.joinUser(joinDto.toDomain()).let {
            BasicResponse.created(BasicResponseDto("가입 성공"))
        }
}