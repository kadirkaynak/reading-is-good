package com.company.readingisgood.controller.impl;

import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerImplTest {

    @InjectMocks
    private BookControllerImpl bookController;

    @Mock
    private BookService bookService;

    @Test
    public void Given_Request_When_CreateBook_Then_ReturnBookOutputDto() {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        BookOutputDto bookOutputDto = BookOutputDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        when(bookService.create(any(BookCreateDto.class))).thenReturn(bookOutputDto);
        //
        // When
        //
        ResponseEntity<BookOutputDto> book = bookController.createBook(bookCreateDto);
        //
        // Then
        //
        Assertions.assertEquals(200, book.getStatusCodeValue());
    }

    @Test
    public void Given_Id_When_UpdateBook_Then_ReturnBoolean() {
        //
        // Given
        //
        BookUpdateDto bookUpdateDto = BookUpdateDto.builder().amount(10).build();
        when(bookService.update(anyLong(), any(BookUpdateDto.class))).thenReturn(true);
        //
        // When
        //
        ResponseEntity<Boolean> booleanResponseEntity = bookController.updateBook(0L, bookUpdateDto);
        //
        // Then
        //
        Assertions.assertEquals(200, booleanResponseEntity.getStatusCodeValue());
    }

}