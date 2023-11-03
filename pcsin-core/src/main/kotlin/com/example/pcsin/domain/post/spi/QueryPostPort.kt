package com.example.pcsin.domain.post.spi

import com.example.pcsin.domain.post.dto.PagingDto
import com.example.pcsin.domain.post.dto.PostListOfPage

interface QueryPostPort {
    fun pagingPost(pagingDto: PagingDto): PostListOfPage
}