package com.example.pcsin.security.handler

import com.example.pcsin.exception.GenericException
import com.example.pcsin.global.dto.response.BasicResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityExceptionHandler: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        runCatching {
            filterChain.doFilter(request, response)
        }.onFailure {
            fun errorHandler(status: Int, msg: String) {
                response.status = status
                response.contentType = MediaType.APPLICATION_JSON.toString()

                val rs = response.outputStream ?: return

                val mapper = ObjectMapper()
                val resBody = BasicResponseDto(msg)
                mapper.writeValue(rs, resBody)

                rs.flush()
            }

            if (it is GenericException) {
                errorHandler(it.code.code, it.code.msg)
            } else if (it is Exception) {
                it.printStackTrace()
                errorHandler(500, "서버 에러")
            }
        }
    }

}