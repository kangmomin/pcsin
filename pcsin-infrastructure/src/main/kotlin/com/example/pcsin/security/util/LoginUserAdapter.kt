package com.example.pcsin.security.util

import com.example.pcsin.common.security.LoginUser
import com.example.pcsin.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class LoginUserAdapter: LoginUser {
    override fun get(): UUID {
        val authentication = SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return authentication.getUserId()
    }
}