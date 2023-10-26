package com.example.pcsin.global.exception

import com.example.pcsin.exception.ErrorCode
import com.example.pcsin.exception.GenericException
import com.example.pcsin.global.dto.response.BasicResponse
import com.example.pcsin.global.dto.response.BasicResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception): ResponseEntity<BasicResponseDto> {
        e.printStackTrace()
        return BasicResponse.error(ErrorCode.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(GenericException::class)
    fun genericExceptionHandler(e: GenericException): ResponseEntity<BasicResponseDto> =
        BasicResponse.error(e.code)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validExceptionHandler(e: MethodArgumentNotValidException) =
        BasicResponse.validError(e.fieldError?.defaultMessage ?: "데이터 규칙에 어긋납니다.")

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun jsonNotReadableException(e: HttpMessageNotReadableException) =
        BasicResponse.error(ErrorCode.JSON_NOT_READABLE)
}