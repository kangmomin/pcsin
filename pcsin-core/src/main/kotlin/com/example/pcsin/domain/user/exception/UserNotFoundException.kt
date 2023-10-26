package com.example.pcsin.domain.user.exception

import com.example.pcsin.exception.ErrorCode
import com.example.pcsin.exception.GenericException

class UserNotFoundException: GenericException(code = ErrorCode.USER_NOT_FOUND)