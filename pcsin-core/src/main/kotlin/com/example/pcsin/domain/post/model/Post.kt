package com.example.pcsin.domain.post.model

import java.time.LocalDateTime
import java.util.*

data class Post(
    var postId: Long?,
    var title: String?,
    var description: String?,
    var userId: UUID?,
    var createdAt: LocalDateTime?,
    var updatedAt: LocalDateTime?,
)