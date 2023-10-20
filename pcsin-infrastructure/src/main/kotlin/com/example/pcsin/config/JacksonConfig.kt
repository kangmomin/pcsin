package com.example.pcsin.config

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.time.format.DateTimeFormatter

@Configuration
class WebConfig: WebMvcConfigurer {
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        val converter = MappingJackson2HttpMessageConverter()
        converters.add(converter)
    }

    @Bean
    fun jacksonConfig(): Jackson2ObjectMapperBuilder =
        Jackson2ObjectMapperBuilder()
            .serializers(LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
}