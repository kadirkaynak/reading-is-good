package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.entity.Book;
import com.company.readingisgood.mapper.BookMapper;
import com.company.readingisgood.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @Mock
    private SequenceGeneratorService sequenceGenerator;

    private Book book;

    @BeforeEach
    public void setUp(){
        book = Book.builder().bookId(1L).amount(10).name("Animal Farm").author("George Orwell").price(10.0).build();
    }

    @Test
    public void Given_Book_When_SaveBook_Then_ReturnBook() {
        //
        // Given
        //
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        //
        // When
        //
        Book saveBook = bookService.saveBook(book);
        //
        // Then
        //
        Assertions.assertEquals(book, saveBook);
    }

    @Test
    public void Given_Id_When_FindById_Then_ReturnBook() {
        //
        // Given
        //
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(book));
        //
        // When
        //
        Book findBook = bookService.findBookById(1L);
        //
        // Then
        //
        Assertions.assertEquals(book, findBook);
    }

    @Test
    public void Given_Request_When_Create_Then_ReturnBookOutputDto() {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        BookOutputDto bookOutputDto = BookOutputDto.builder().bookId(1L).name("Animal Farm").author("George Orwell").price(10.0).build();

        when(bookRepository.save(any(Book.class))).thenReturn(book);
        when(sequenceGenerator.generateSequence(Book.SEQUENCE_NAME)).thenReturn(1L);
        when(bookMapper.toBook(any(BookCreateDto.class))).thenReturn(book);
        when(bookMapper.toBookOutputDto(any(Book.class))).thenReturn(bookOutputDto);
        //
        // When
        //
        BookOutputDto bookOut = bookService.create(bookCreateDto);
        //
        // Then
        //
        Assertions.assertEquals(book.getBookId(), bookOut.getBookId());
    }

    @Test
    public void Given_Request_When_Update_Then_ReturnBoolean() {
        //
        // Given
        //
        BookUpdateDto bookUpdateDto = BookUpdateDto.builder().amount(10).build();
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(book));
        //
        // When
        //
        boolean booleanOut = bookService.update(1L, bookUpdateDto);
        //
        // Then
        //
        Assertions.assertTrue(booleanOut);
    }
}