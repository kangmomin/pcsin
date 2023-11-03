package com.example.pcsin.domain.post.dto

data class PagingDto (
    /** 한 페이지에 들어갈 글의 갯수 */
    val postPerPage: Int = 20,
    val page: Int = 1,
)
