package com.example.pcsin.domain.post.repository

import com.example.pcsin.domain.post.entity.PostEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: CrudRepository<PostEntity, Long> {
}