package com.example.pcsin.global.exception

import com.example.pcsin.exception.ErrorCode
import com.example.pcsin.exception.GenericException
import com.example.pcsin.global.dto.response.BasicResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(GenericException::class)
    fun genericExceptionHandler(e: ErrorCode): ResponseEntity<String> = BasicResponse.error(e)

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception): ResponseEntity<String> {
        e.printStackTrace()
        return BasicResponse.error(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}