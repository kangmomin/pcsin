package com.example.pcsin.domain.post.spi

import com.example.pcsin.domain.post.model.Post

interface CommandPostPort {
    fun writePost(post: Post): Long
}