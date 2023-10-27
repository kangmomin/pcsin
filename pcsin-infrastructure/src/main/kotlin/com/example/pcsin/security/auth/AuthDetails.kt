package com.example.pcsin.security.auth

import com.example.pcsin.domain.user.exception.UserNotFoundException
import com.example.pcsin.domain.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

class AuthDetails(
    private val user: User
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = ArrayList()

    override fun getPassword(): String? = null
    override fun getUsername(): String = user.email ?: throw UserNotFoundException()

    fun getUserId(): UUID = user.userId ?: throw UserNotFoundException()

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean =
        isAccountNonExpired() && isCredentialsNonExpired() && isAccountNonLocked()
}