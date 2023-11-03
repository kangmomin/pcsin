package com.example.pcsin.domain.post.repository.custom

import com.example.pcsin.domain.post.dto.PostListOfPage
import com.example.pcsin.domain.post.model.Post
import org.springframework.data.domain.Page

interface PostRepositoryPagingCustom {

    fun pagingPost(page: PostListOfPage): Page<Post>
}