package com.example.pcsin.domain.user.repository

import com.example.pcsin.domain.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<UserEntity, UUID> {

}