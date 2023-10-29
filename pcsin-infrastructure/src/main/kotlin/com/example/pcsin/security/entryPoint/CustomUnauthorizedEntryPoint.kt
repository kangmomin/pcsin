package com.example.pcsin.security.entryPoint

import com.example.pcsin.global.dto.response.BasicResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomUnauthorizedEntryPoint: AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        if (response == null) return

        response.status = 401
        response.contentType = MediaType.APPLICATION_JSON.toString()

        val rs = response.outputStream ?: return

        val mapper = ObjectMapper()
        val resBody = BasicResponseDto("로그인이 필요한 작업입니다.")
        mapper.writeValue(rs, resBody)

        rs.flush()
    }
}