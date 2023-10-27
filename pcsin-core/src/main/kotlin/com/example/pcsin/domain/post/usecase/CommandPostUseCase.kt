package com.example.pcsin.domain.post.usecase

import com.example.pcsin.common.annotation.UseCase
import com.example.pcsin.domain.post.model.Post

@UseCase
interface CommandPostUseCase {
    fun writePost(post: Post): Long
}