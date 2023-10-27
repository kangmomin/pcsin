package com.example.pcsin.domain.post

import com.example.pcsin.domain.post.exception.PostNotSavedException
import com.example.pcsin.domain.post.mapper.PostMapper
import com.example.pcsin.domain.post.model.Post
import com.example.pcsin.domain.post.repository.PostRepository
import com.example.pcsin.domain.post.spi.PostPort

class PostPersistenceAdapter(
    private val postMapper: PostMapper,
    private val postRepository: PostRepository
): PostPort {
    override fun writePost(post: Post): Long =
        postRepository.save(postMapper.toEntity(post)).id ?: throw PostNotSavedException()
}