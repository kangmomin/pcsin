package com.example.pcsin.domain.user.service

import com.example.pcsin.domain.user.exception.UserAlreadyExistException
import com.example.pcsin.domain.user.model.User
import com.example.pcsin.domain.user.spi.CommandUserPort
import com.example.pcsin.domain.user.usecase.CommandUserUseCase
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CommandUserServiceTest(
    @Mock
    private val commandUserPort: CommandUserPort,
    @Mock
    private val commandUserUseCase: CommandUserUseCase
) {

    // Joining a new user with valid input should create a new user with encoded password and salt
    @Test
    fun test_join_user_with_valid_input_should_create_new_user() {
        // Arrange
        val user = User(email = "test@example.com", name = "Test User", password = "password")

        // Act
        assertDoesNotThrow { commandUserUseCase.joinUser(user) }
    }

    // Joining a new user with valid input should call 'createUserWhenNotExist' method of 'CommandUserPort'
    @Test
    fun test_join_user_with_valid_input_should_call_createUserWhenNotExist() {
        // Arrange
        val user = User(email = "test@example.com", name = "Test User", password = "password")

        // Act
        commandUserUseCase.joinUser(user)

        // Assert
        verify(commandUserPort).createUserWhenNotExist(user)
    }

    // Joining a new user with already existing email should throw 'UserAlreadyExistException'
    @Test
    fun test_join_user_with_existing_email_should_throw_UserAlreadyExistException() {
        // Arrange
        val user = User(email = "existing@example.com", name = "Existing User", password = "password")
        commandUserPort.createUserWhenNotExist(user)

        // Act & Assert
        assertThrows<UserAlreadyExistException> {
            commandUserUseCase.joinUser(user)
        }
    }

    // Joining a new user with null password should throw 'NullPointerException'
    @Test
    fun test_join_user_with_null_password_should_throw_NullPointerException() {
        // Arrange
        val user = User(email = "test@example.com", name = "Test User", password = null)

        // Act & Assert
        assertThrows<NullPointerException> {
            commandUserUseCase.joinUser(user)
        }
    }

    // Joining a new user with null email should throw 'NullPointerException'
    @Test
    fun test_join_user_with_null_email_should_throw_NullPointerException() {
        // Arrange
        val user = User(email = null, name = "Test User", password = "password")

        // Act & Assert
        assertThrows<NullPointerException> {
            commandUserUseCase.joinUser(user)
        }
    }

    // Joining a new user with null name should not throw any exception
    @Test
    fun test_join_user_with_null_name_should_not_throw_any_exception() {
        // Arrange
        val user = User(email = "test@example.com", name = null, password = "password")

        // Act & Assert
        assertDoesNotThrow {
            commandUserUseCase.joinUser(user)
        }
    }
}