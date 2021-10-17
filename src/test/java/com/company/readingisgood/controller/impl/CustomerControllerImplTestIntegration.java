package com.company.readingisgood.controller.impl;

import com.company.readingisgood.auth.TokenManager;
import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerImplTestIntegration {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void Given_Request_When_CreateCustomer_Then_Return200() throws Exception {
        //
        // Given
        //
        CustomerCreateDto customerCreateDto = CustomerCreateDto.builder().name("name").surname("surname").email("email@gmail.com").phone("0500000000").build();
        String token = tokenManager.generateToken("isgood");
        assertNotNull(token);
        //
        // When
        //
        token = "Bearer " + token;
        MvcResult result = mockMvc.perform(post("/v1/customer")
                .header("Authorization", token)
                .content(objectMapper.writeValueAsString(customerCreateDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        //
        // Then
        //
        assertEquals(200, result.getResponse().getStatus());
    }
}