package com.example.pcsin.security.util

import com.example.pcsin.common.security.LoginUser
import com.example.pcsin.security.auth.AuthDetails
import com.example.pcsin.security.exception.UnAuthorizedException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.*

@Component
class LoginUserAdapter: LoginUser {
    override fun get(): UUID {
        try {
            val authentication = SecurityContextHolder.getContext().authentication.principal as AuthDetails
            return authentication.getUserId()
        } catch (e: Exception) {
            throw UnAuthorizedException()
        }
    }
}