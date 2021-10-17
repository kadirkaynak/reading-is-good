package com.company.readingisgood.controller;

import com.company.readingisgood.dto.input.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/login")
public interface AuthController {

        @PostMapping()
        ResponseEntity<String> login(@RequestBody LoginRequest loginRequest);

}
