package com.example.pcsin.domain.post.usecase

import com.example.pcsin.common.annotation.ReadOnlyUseCase
import com.example.pcsin.domain.post.dto.PostListOfPage
import com.example.pcsin.domain.post.dto.PagingDto

@ReadOnlyUseCase
interface QueryPostUseCase {

    fun pagedPostList(page: PagingDto): PostListOfPage
}