package com.company.readingisgood.controller.impl;

import com.company.readingisgood.dto.input.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerImplTestIntegration {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Given_LoginRequest_When_Login_Then_Return200() throws Exception {
        //
        // Given
        //
        LoginRequest loginRequest = LoginRequest.builder().username("isgood").password("reading").build();
        //
        // When
        //
        MvcResult result = mockMvc.perform(post("/login")
                .content(objectMapper.writeValueAsString(loginRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        //
        // Then
        //
        assertEquals(200, result.getResponse().getStatus());
    }
}