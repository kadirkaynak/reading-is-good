package com.company.readingisgood.controller.impl;

import com.company.readingisgood.auth.TokenManager;
import com.company.readingisgood.dto.input.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerImplTest {

    @InjectMocks
    private AuthControllerImpl authController;

    @Mock
    private TokenManager tokenManager;

    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    public void Given_LoginRequest_When_Login_Then_ReturnString() {
        //
        // Given
        //
        LoginRequest loginRequest = LoginRequest.builder().username("username").password("pass").build();
        when(authenticationManager.authenticate(any(Authentication.class))).thenReturn(null);
        when(tokenManager.generateToken(anyString())).thenReturn("token");
        //
        // When
        //
        ResponseEntity<String> login = authController.login(loginRequest);
        //
        // Then
        //
        Assertions.assertEquals(200, login.getStatusCodeValue());
    }

    @Test
    public void Given_LoginRequest_When_Login_Then_ThrowError() {
        //
        // Given
        //
        LoginRequest loginRequest = LoginRequest.builder().username("username").password("pass").build();
        when(tokenManager.generateToken(loginRequest.getUsername())).thenThrow(new RuntimeException());
        //
        // When
        //

        //
        // Then
        //
        Assertions.assertThrows(RuntimeException.class, () -> {
            authController.login(loginRequest);
        });
    }
}