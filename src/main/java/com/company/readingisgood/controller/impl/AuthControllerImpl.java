package com.company.readingisgood.controller.impl;

import com.company.readingisgood.auth.TokenManager;
import com.company.readingisgood.controller.AuthController;
import com.company.readingisgood.dto.input.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final TokenManager tokenManager;
    private final AuthenticationManager authenticationManager;

    /**
     * Handles the incoming PUT request "/{id}"
     *
     * @param loginRequest of the login to get auth
     * @return string
     */
    @Override
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUsername()));
        } catch (Exception e) {
            throw e;
        }
    }
}