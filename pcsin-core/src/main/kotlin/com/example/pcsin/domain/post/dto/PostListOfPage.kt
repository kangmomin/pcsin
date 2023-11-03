package com.example.pcsin.domain.post.dto

import com.example.pcsin.domain.post.model.Post

data class PostListOfPage (
    val page: Int,
    val totalCount: Int,
    val totalPage: Int,
    val posts: ArrayList<Post>
)
