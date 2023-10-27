package com.example.pcsin.domain.post.mapper

import com.example.pcsin.domain.post.entity.PostEntity
import com.example.pcsin.domain.post.model.Post
import com.example.pcsin.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class PostMapper: GenericMapper<Post, PostEntity> {
    override fun toDomain(entity: PostEntity): Post? =
        entity.let {
            Post(postId = it.id,
                title = it.title,
                description = it.description,
                userId = it.userId,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt)
        }

    override fun toEntity(domain: Post): PostEntity =
        domain.let {
            PostEntity(id = it.postId,
                title = it.title,
                description = it.description,
                userId = it.userId)
        }
}