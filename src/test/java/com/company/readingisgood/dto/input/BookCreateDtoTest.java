package com.company.readingisgood.dto.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookCreateDtoTest {

    @Test
    public void bookCreateDtoBuilder() {
        //
        // Given
        //
        BookCreateDto bookCreateDto = BookCreateDto.builder().name("Animal Farm").author("George Orwell").price(10.0).build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("George Orwell", bookCreateDto.getAuthor()),
                () -> assertEquals("Animal Farm", bookCreateDto.getName()),
                () -> assertEquals(10.0, bookCreateDto.getPrice())
        );
    }
    @Test
    public void bookCreateDtoGetterSetter() {
        //
        // Given
        //
        BookCreateDto bookCreateDto = new BookCreateDto();
        bookCreateDto.setAuthor("George Orwell");
        bookCreateDto.setName("Animal Farm");
        bookCreateDto.setPrice(10.0);
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("George Orwell", bookCreateDto.getAuthor()),
                () -> assertEquals("Animal Farm", bookCreateDto.getName()),
                () -> assertEquals(10.0, bookCreateDto.getPrice())
        );
    }

}