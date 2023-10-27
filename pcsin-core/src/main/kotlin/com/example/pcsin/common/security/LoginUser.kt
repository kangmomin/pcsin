package com.example.pcsin.common.security

import java.util.UUID

interface LoginUser {
    /** 현재 로그인된 유저의 ID 반환 */
    fun get(): UUID
}