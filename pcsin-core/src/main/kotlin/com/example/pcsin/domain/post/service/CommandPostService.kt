package com.example.pcsin.domain.post.service

import com.example.pcsin.common.annotation.Service
import com.example.pcsin.domain.post.model.Post
import com.example.pcsin.domain.post.spi.CommandPostPort
import com.example.pcsin.domain.post.usecase.CommandPostUseCase

@Service
open class CommandPostService(
    private val commandPostPort: CommandPostPort
): CommandPostUseCase {
    override fun writePost(post: Post) =
        commandPostPort.writePost(post)
}