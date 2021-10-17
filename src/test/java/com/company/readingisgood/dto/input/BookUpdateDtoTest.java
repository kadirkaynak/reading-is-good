package com.company.readingisgood.dto.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookUpdateDtoTest {
    @Test
    public void bookUpdateDtoBuilder() {
        //
        // Given
        //
        BookUpdateDto bookUpdateDto = BookUpdateDto.builder().amount(10).build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(10, bookUpdateDto.getAmount())
        );
    }
    @Test
    public void bookUpdateDtoGetterSetter() {
        //
        // Given
        //
        BookUpdateDto bookUpdateDto = new BookUpdateDto();
        bookUpdateDto.setAmount(10);
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(10, bookUpdateDto.getAmount())
        );
    }
}