package com.example.pcsin.domain.post.service

import com.example.pcsin.common.annotation.Service
import com.example.pcsin.domain.post.dto.PagingDto
import com.example.pcsin.domain.post.dto.PostListOfPage
import com.example.pcsin.domain.post.spi.QueryPostPort
import com.example.pcsin.domain.post.usecase.QueryPostUseCase

@Service
class QueryPostService(
    private val queryPostPort: QueryPostPort
): QueryPostUseCase {
    override fun pagedPostList(page: PagingDto): PostListOfPage =
        queryPostPort.pagingPost(page)
}