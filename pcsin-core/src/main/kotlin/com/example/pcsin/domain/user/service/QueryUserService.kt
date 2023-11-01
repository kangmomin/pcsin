package com.example.pcsin.domain.user.service

import com.example.pcsin.common.annotation.Service
import com.example.pcsin.common.security.JwtProperties
import com.example.pcsin.common.security.JwtProvider
import com.example.pcsin.common.security.PasswordUtil
import com.example.pcsin.domain.user.dto.JwtTokens
import com.example.pcsin.domain.user.exception.UserNotFoundException
import com.example.pcsin.domain.user.model.User
import com.example.pcsin.domain.user.spi.QueryUserPort
import com.example.pcsin.domain.user.usecase.QueryUserUseCase

@Service
open class QueryUserService(
    private val queryUserPort: QueryUserPort,
    private val passwordUtil: PasswordUtil,
    private val jwtProvider: JwtProvider,
): QueryUserUseCase {
    override fun login(loginRequest: User): JwtTokens =
        loginRequest.let {
            val loginInfo = queryUserPort.loginInfo(it.email!!)

            if (!passwordUtil.match(loginRequest.password!!,
                loginInfo.salt, loginInfo.password)) throw UserNotFoundException()

            val accessToken = jwtProvider.generateAccessToken(loginInfo.email)
            val refreshToken = jwtProvider.generateRefreshToken(loginInfo.email)

            JwtTokens(
                accessToken = JwtProperties.PREFIX + accessToken,
                refreshToken = JwtProperties.PREFIX + refreshToken)
        }
}