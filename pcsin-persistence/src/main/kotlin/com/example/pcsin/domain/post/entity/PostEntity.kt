package com.example.pcsin.domain.post.entity

import com.example.pcsin.common.entity.BasicTimeEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "post")
class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    val id: Long?,

    @Column(nullable = false)
    val title: String?,

    @Column(nullable = false)
    val description: String?,

    @Column(nullable = false)
    val userId: UUID?
): BasicTimeEntity() {
}