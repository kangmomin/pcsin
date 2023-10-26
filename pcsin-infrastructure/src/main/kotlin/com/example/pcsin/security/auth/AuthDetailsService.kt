package com.example.pcsin.security.auth

import com.example.pcsin.domain.user.spi.QueryUserPort
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userPort: QueryUserPort
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails =
        AuthDetails(userPort.findByEmail(username ?: ""))
}