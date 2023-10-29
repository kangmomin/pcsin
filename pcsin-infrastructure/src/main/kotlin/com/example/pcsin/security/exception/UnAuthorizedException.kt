package com.example.pcsin.security.exception

import com.example.pcsin.exception.ErrorCode
import com.example.pcsin.exception.GenericException

class UnAuthorizedException : GenericException(code = ErrorCode.UNAUTHORIZED)
