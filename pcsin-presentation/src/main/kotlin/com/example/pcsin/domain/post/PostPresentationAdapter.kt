package com.example.pcsin.domain.post

import com.example.pcsin.common.security.LoginUser
import com.example.pcsin.domain.post.dto.request.WritePostRequest
import com.example.pcsin.domain.post.dto.response.WritePostResponse
import com.example.pcsin.domain.post.usecase.CommandPostUseCase
import com.example.pcsin.domain.post.usecase.QueryPostUseCase
import com.example.pcsin.global.dto.response.BasicResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostPresentationAdapter(
    private val commandPostUseCase: CommandPostUseCase,
    private val queryPostUseCase: QueryPostUseCase,
    private val loginUser: LoginUser
) {

    @PostMapping("/write")
    fun writePost(@RequestBody @Valid writePostRequest: WritePostRequest): ResponseEntity<Any?> =
        commandPostUseCase.writePost(writePostRequest.toDomain(loginUser.get())).let {
            BasicResponse.created(
                WritePostResponse("글이 성공적으로 작성되었습니다.", it))
        }
}