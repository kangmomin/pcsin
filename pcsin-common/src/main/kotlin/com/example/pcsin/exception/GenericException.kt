package com.example.pcsin.exception

open class GenericException(open val code: ErrorCode): RuntimeException() {
}