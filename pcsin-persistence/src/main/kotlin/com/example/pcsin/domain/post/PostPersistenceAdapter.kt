package com.example.pcsin.domain.post

import com.example.pcsin.domain.post.dto.PagingDto
import com.example.pcsin.domain.post.dto.PostListOfPage
import com.example.pcsin.domain.post.exception.PostNotSavedException
import com.example.pcsin.domain.post.mapper.PostMapper
import com.example.pcsin.domain.post.model.Post
import com.example.pcsin.domain.post.repository.PostRepository
import com.example.pcsin.domain.post.spi.PostPort
import org.springframework.stereotype.Component

@Component
class PostPersistenceAdapter(
    private val postMapper: PostMapper,
    private val postRepository: PostRepository
): PostPort {
    override fun writePost(post: Post): Long =
        postRepository.save(postMapper.toEntity(post)).id ?: throw PostNotSavedException()

    override fun pagingPost(pagingDto: PagingDto): PostListOfPage = PostListOfPage(0, 0, 0, ArrayList())
}