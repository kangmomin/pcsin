package com.example.pcsin.security.entryPoint

import com.example.pcsin.global.dto.response.BasicResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component

@Component
class CustomForbiddenEntryPoint: AccessDeniedHandler {
    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        accessDeniedException: AccessDeniedException?
    ) {
        if (response == null) return

        response.status = 403
        response.contentType = MediaType.APPLICATION_JSON.toString()

        val rs = response.outputStream ?: return

        val mapper = ObjectMapper()
        val resBody = BasicResponseDto("작업에 필요한 권한이 부족합니다.")
        mapper.writeValue(rs, resBody)

        rs.flush()
    }
}