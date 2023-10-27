package com.example.pcsin.domain.post.exception

import com.example.pcsin.exception.ErrorCode
import com.example.pcsin.exception.GenericException

class PostNotSavedException: GenericException(code = ErrorCode.POST_NOT_SAVED)