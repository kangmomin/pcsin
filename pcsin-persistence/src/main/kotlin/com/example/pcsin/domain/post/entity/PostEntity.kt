package com.example.pcsin.domain.post.entity

import com.example.pcsin.common.entity.BasicTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

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