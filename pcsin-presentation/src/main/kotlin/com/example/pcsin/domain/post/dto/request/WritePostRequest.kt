package com.example.pcsin.domain.post.dto.request

import com.example.pcsin.domain.post.model.Post
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDateTime
import java.util.UUID

data class WritePostRequest(
    @NotEmpty(message = "제목이 입력 되지 않았습니다")
    val title: String,

    @NotEmpty(message = "내용이 입력 되지 않았습니다")
    val description: String,
) {
    fun toDomain(userId: UUID) =
        Post(postId = null,
            userId = userId,
            title = this.title,
            description = this.description,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now())
}
