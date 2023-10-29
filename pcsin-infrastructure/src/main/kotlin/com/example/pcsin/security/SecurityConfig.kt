package com.example.pcsin.security

import com.example.pcsin.jwt.JwtFilter
import com.example.pcsin.jwt.JwtProviderImpl
import com.example.pcsin.security.entryPoint.CustomUnauthorizedEntryPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
    private val jwtProviderImpl: JwtProviderImpl,
    private val customUnauthorizedEntryPoint: CustomUnauthorizedEntryPoint
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.csrf{ it.disable() }
            .cors{ it.disable() }
            .formLogin{ it.disable() }
            .authorizeHttpRequests{
                it.requestMatchers("/user/join", "/user/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .addFilterBefore(JwtFilter(jwtProviderImpl), UsernamePasswordAuthenticationFilter::class.java)
            .exceptionHandling{
                it.authenticationEntryPoint(customUnauthorizedEntryPoint)
            }
            .sessionManagement{
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

        return http.build()
    }

    @Bean
    fun PasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}