package com.example.pcsin.jwt

import io.jsonwebtoken.security.Keys

object JwtKeys {
    val SECRET = Keys.hmacShaKeyFor("paowdpawdasdwasd!#@#!@#Asdwa2132@#aowk".toByteArray(Charsets.UTF_8))
}