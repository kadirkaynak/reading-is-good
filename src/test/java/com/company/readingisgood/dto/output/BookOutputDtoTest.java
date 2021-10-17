package com.company.readingisgood.dto.output;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookOutputDtoTest {

    @Test
    public void bookOutputDtoBuilder() {
        //
        // Given
        //
        BookOutputDto bookOutputDto = BookOutputDto.builder().bookId(1l).amount(10).name("Animal Farm").author("George Orwell").price(10.0).build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(1L, bookOutputDto.getBookId()),
                () -> assertEquals("Animal Farm", bookOutputDto.getName()),
                () -> assertEquals("George Orwell", bookOutputDto.getAuthor()),
                () -> assertEquals(10, bookOutputDto.getAmount()),
                () -> assertEquals(10.0, bookOutputDto.getPrice())
        );
    }
    @Test
    public void bookOutputDtoGetterSetter() {
        //
        // Given
        //
        BookOutputDto bookOutputDto = new BookOutputDto();
        bookOutputDto.setAuthor("George Orwell");
        bookOutputDto.setName("Animal Farm");
        bookOutputDto.setBookId(1L);
        bookOutputDto.setAmount(10);
        bookOutputDto.setPrice(10.0);
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(1L, bookOutputDto.getBookId()),
                () -> assertEquals("Animal Farm", bookOutputDto.getName()),
                () -> assertEquals("George Orwell", bookOutputDto.getAuthor()),
                () -> assertEquals(10, bookOutputDto.getAmount()),
                () -> assertEquals(10.0, bookOutputDto.getPrice())
        );
    }
}