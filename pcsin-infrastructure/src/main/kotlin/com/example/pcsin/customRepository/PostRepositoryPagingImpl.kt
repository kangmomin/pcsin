package com.example.pcsin.customRepository

import com.example.pcsin.domain.post.dto.PostListOfPage
import com.example.pcsin.domain.post.model.Post
import com.example.pcsin.domain.post.repository.custom.PostRepositoryPagingCustom
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page

class PostRepositoryPagingImpl(
    private val query: JPAQueryFactory
): PostRepositoryPagingCustom {
    override fun pagingPost(page: PostListOfPage): Page<Post> {
//        query.select()
//            .from()

        return Page.empty()
    }
}