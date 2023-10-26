package com.example.pcsin.domain.user

import com.example.pcsin.domain.user.dto.UserLoginInfoDto
import com.example.pcsin.domain.user.exception.UserNotFoundException
import com.example.pcsin.domain.user.mapper.UserMapper
import com.example.pcsin.domain.user.model.User
import com.example.pcsin.domain.user.repository.UserRepository
import com.example.pcsin.domain.user.spi.UserPort
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    val userRepository: UserRepository,
    val userMapper: UserMapper
): UserPort {
    override fun createUserWhenNotExist(user: User): User? =
        userRepository.existsByEmail(user.email!!).let {
            if (it) return null

            userRepository.save(userMapper.toEntity(user)).let {
                userMapper.toDomain(it)
            }
        }

    override fun loginInfo(email: String): UserLoginInfoDto =
        userRepository.findByEmail(email).let {
            it ?: throw UserNotFoundException()
            UserLoginInfoDto(
                email = it.email!!,
                password = it.password!!,
                salt = it.salt!!)
        }

    override fun findByEmail(email: String): User =
        userRepository.findByEmail(email).let {
            userMapper.toDomain(it ?: throw UserNotFoundException())!!
        }
}