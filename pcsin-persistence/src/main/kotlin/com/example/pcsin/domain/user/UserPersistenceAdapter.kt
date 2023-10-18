package com.example.pcsin.domain.user

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
        userRepository.save(userMapper.toEntity(user)).let {
            userMapper.toDomain(it)
        }
}