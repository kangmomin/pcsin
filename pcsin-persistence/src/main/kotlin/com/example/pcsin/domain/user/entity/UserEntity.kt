package com.example.pcsin.domain.user.entity

import com.example.pcsin.common.entity.BasicTimeEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "user")
class UserEntity (

    @Id @Column(name="userId")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,

    @Column(
        nullable = false,
        unique = true
    )
    val email: String?,

    @Column(nullable = false)
    val password: String?,

    @Column(nullable = false)
    val salt: String?,

    @Column(nullable = false, unique = true)
    val name: String?
) : BasicTimeEntity()