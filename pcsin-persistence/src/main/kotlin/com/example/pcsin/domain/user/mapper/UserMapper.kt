package com.example.pcsin.domain.user.mapper

import com.example.pcsin.domain.user.entity.UserEntity
import com.example.pcsin.domain.user.model.User
import com.example.pcsin.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class UserMapper: GenericMapper<User, UserEntity> {
    override fun toDomain(entity: UserEntity): User? =
        entity.let {
            User(
                name = it.name,
                userId = it.id,
                password = it.password,
                email = it.email,
                salt = it.salt,
                createdAt = it.createdAt,
                lastUpdatedAt = it.updatedAt,
            )
        }

    override fun toEntity(domain: User): UserEntity =
        domain.let {
            UserEntity(
                id = it.userId,
                name = it.name,
                email = it.email,
                password = it.password,
                salt = it.salt,
            )
        }
}