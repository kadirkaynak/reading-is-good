package com.company.readingisgood.dto.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LoginRequestTest {
    @Test
    public void loginRequestBuilder() {
        //
        // Given
        //
        LoginRequest loginRequest = LoginRequest.builder().username("username").password("pass").build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("username", loginRequest.getUsername()),
                () -> assertEquals("pass", loginRequest.getPassword())
        );
    }
    @Test
    public void loginRequestGetterSetter() {
        //
        // Given
        //
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("pass");
        loginRequest.setUsername("username");
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("username", loginRequest.getUsername()),
                () -> assertEquals("pass", loginRequest.getPassword())
        );
    }
}