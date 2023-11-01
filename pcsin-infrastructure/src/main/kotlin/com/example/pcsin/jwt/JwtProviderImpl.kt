package com.example.pcsin.jwt

import com.example.pcsin.common.security.JwtProperties
import com.example.pcsin.common.security.JwtProvider
import com.example.pcsin.exception.ExpiredTokenException
import com.example.pcsin.exception.InvalidTokenException
import com.example.pcsin.security.auth.AuthDetailsService
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList

@Component
class JwtProviderImpl(
    private val authDetailsService: AuthDetailsService
): JwtProvider {
    override fun generateAccessToken(email: String): String =
        generateToken(email, JwtProperties.ACCESS_TYPE, JwtProperties.ACCESS_EXP)

    // TODO: Redis 연동 필요
    override fun generateRefreshToken(email: String): String =
        generateToken(email, JwtProperties.REFRESH_TYPE, JwtProperties.REFRESH_EXP)

    private fun generateToken(email: String, type: String, exp: Long): String =
        Jwts.builder()
            .signWith(JwtKeys.SECRET)
            .setSubject(type)
            .claim("email", email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()

    override fun resolveAccessToken(token: String): String? {
        try {
            if (!token.startsWith(JwtProperties.PREFIX)) throw InvalidTokenException()

            val replacedToken = token.replace(JwtProperties.PREFIX, "")
            val jwtData = Jwts.parserBuilder()
                .setSigningKey(JwtKeys.SECRET)
                .build()
                .parseClaimsJws(replacedToken)
            return jwtData
                .body["email"].toString()
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException()
        } catch (e: Exception) {
            throw InvalidTokenException()
        }
    }

    // TODO: Redis 연동 필요
    override fun resolveRefreshToken(token: String): String? {
        try {
            if (!token.startsWith(JwtProperties.PREFIX)) return null

            val replacedToken = token.replace(JwtProperties.PREFIX, "")
            return Jwts.parserBuilder()
                .setSigningKey(JwtKeys.SECRET)
                .build()
                .parseClaimsJws(replacedToken)
                .body["email"].toString()
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException()
        } catch (e: Exception) {
            throw InvalidTokenException()
        }
    }

    fun getAuthentication(token: String): Authentication {
        val user: UserDetails = authDetailsService.loadUserByUsername(resolveAccessToken(token))
        return UsernamePasswordAuthenticationToken(user, "", ArrayList())
    }
}