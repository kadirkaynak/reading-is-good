package com.company.readingisgood.controller.impl;

import com.company.readingisgood.auth.TokenManager;
import com.company.readingisgood.dto.input.BookCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@AutoConfigureMockMvc
public class StatisticsControllerImplTestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TokenManager tokenManager;

    @Test
    public void Given_When_GetStatistics_Then_Return200() throws Exception {
        //
        // Given
        //
        String token = tokenManager.generateToken("isgood");
        assertNotNull(token);
        //
        // When
        //
        token = "Bearer " + token;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/v1/statistics").header("Authorization", token)).andReturn();
        //
        // Then
        //
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void Given_When_GetStatistics_Then_Return403() throws Exception {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        //
        // When
        //
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/v1/statistics")).andReturn();
        //
        // Then
        //
        assertEquals(403, result.getResponse().getStatus());
    }
}