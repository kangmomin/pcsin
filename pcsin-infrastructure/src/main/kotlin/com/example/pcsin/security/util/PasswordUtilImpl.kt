package com.example.pcsin.security.util

import com.example.pcsin.common.annotation.Util
import com.example.pcsin.common.security.PasswordUtil
import org.springframework.security.crypto.password.PasswordEncoder
import java.security.SecureRandom
import java.util.*

@Util
class PasswordUtilImpl(
    private val pwdEncoder: PasswordEncoder
): PasswordUtil {
    override fun encode(password: String, salt: String): String =
        pwdEncoder.encode(password + salt)
    override fun match(rawPassword: String, salt: String, encodedPassword: String) {
        pwdEncoder.matches(rawPassword + salt, encodedPassword)
    }

    override fun generateSalt(): String {
        val random = SecureRandom()
        val saltBytes = ByteArray(16)
        random.nextBytes(saltBytes)
        return Base64.getEncoder().encodeToString(saltBytes)
    }
}