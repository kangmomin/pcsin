package com.example.pcsin.global.dto.response

import com.example.pcsin.exception.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class BasicResponse<T> (
    val data: T,
    val status: Int
) {
    companion object {
        fun error(code: ErrorCode): ResponseEntity<BasicResponseDto> = ResponseEntity
                .status(code.code)
                .body(BasicResponseDto(code.msg))
        fun validError(msg: String): ResponseEntity<BasicResponseDto> = ResponseEntity
                .status(400)
                .body(BasicResponseDto(msg))

        fun created(data: Any?) = ResponseEntity
            .status(HttpStatus.CREATED)
            .body(data)

        fun ok(data: Any?) = ResponseEntity
            .status(HttpStatus.OK)
            .body(data)
    }
}