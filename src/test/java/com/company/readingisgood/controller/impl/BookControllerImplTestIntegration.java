package com.company.readingisgood.controller.impl;

import com.company.readingisgood.auth.TokenManager;
import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import com.company.readingisgood.entity.Book;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerImplTestIntegration {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void Given_LoginRequest_When_Login_Then_Return200() throws Exception {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        String token = tokenManager.generateToken("isgood");
        assertNotNull(token);
        //
        // When
        //
        token = "Bearer " + token;
        MvcResult result = mockMvc.perform(post("/v1/book")
                .header("Authorization", token)
                .content(objectMapper.writeValueAsString(bookCreateDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        //
        // Then
        //
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void Given_LoginRequest_When_Login_Then_Return403() throws Exception {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        //
        // When
        //
        MvcResult result = mockMvc.perform(post("/v1/book")
                .contentType("application/json;charset=UTF-8")
                .content(objectMapper.writeValueAsString(bookCreateDto))).andReturn();
        //
        // Then
        //
        assertEquals(403, result.getResponse().getStatus());
    }



    @Test
    public void Given_Request_When_UpdateBook_Then_Return200() throws Exception {
        //
        // Given
        //
        Book book = Book.builder().bookId(1L).amount(10).name("Animal Farm").author("George Orwell").price(10.0).build();
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(book));
        BookUpdateDto bookUpdateDto = BookUpdateDto.builder().amount(10).build();
        String token = tokenManager.generateToken("isgood");
        assertNotNull(token);
        //
        // When
        //
        token = "Bearer " + token;
        MvcResult result = mockMvc.perform(put("/v1/book/1")
                .header("Authorization", token)
                .content(objectMapper.writeValueAsString(bookUpdateDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        //
        // Then
        //
        assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    public void Given_Request_When_UpdateBook_Then_Return404() throws Exception {
        //
        // Given
        //
        BookUpdateDto bookUpdateDto = BookUpdateDto.builder().amount(10).build();
        String token = tokenManager.generateToken("isgood");
        assertNotNull(token);
        //
        // When
        //
        token = "Bearer " + token;
        MvcResult result = mockMvc.perform(put("/v1/book/1")
                .header("Authorization", token)
                .content(objectMapper.writeValueAsString(bookUpdateDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        //
        // Then
        //
        assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    public void Given_Request_When_UpdateBook_Then_Return403() throws Exception {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        //
        // When
        //
        MvcResult result = mockMvc.perform(put("/v1/book/1")
                .contentType("application/json;charset=UTF-8")
                .content(objectMapper.writeValueAsString(bookCreateDto))).andReturn();
        //
        // Then
        //
        assertEquals(403, result.getResponse().getStatus());
    }
}