package com.example.pcsin.domain.user.exception

import com.example.pcsin.exception.ErrorCode
import com.example.pcsin.exception.GenericException

class UserAlreadyExistException(
    override val code: ErrorCode = ErrorCode.USER_ALREADY_EXIST
): GenericException(code)
