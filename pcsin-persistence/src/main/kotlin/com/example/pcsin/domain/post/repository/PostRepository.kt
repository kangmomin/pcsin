package com.example.pcsin.domain.post.repository

import com.example.pcsin.domain.post.entity.PostEntity
import com.example.pcsin.domain.post.repository.custom.PostRepositoryPagingCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<PostEntity, Long>, PostRepositoryPagingCustom {
}