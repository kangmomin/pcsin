package com.example.pcsin.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.csrf{ it.disable() }
            .cors{ it.disable() }
            .formLogin{ it.disable() }
            .authorizeHttpRequests{
                it.requestMatchers("/user/join", "/user/login")
                    .permitAll()
                    .anyRequest()
                    .permitAll()
            }
            .exceptionHandling{

            }
            .sessionManagement{
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

        return http.build()
    }

    @Bean
    protected fun PasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}