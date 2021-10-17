package com.company.readingisgood.dto.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderCreateDtoTest {
    @Test
    public void orderCreateDtoBuilder() {
        //
        // Given
        //
        OrderCreateDto orderCreateDto = OrderCreateDto.builder().bookId(1L).customerId(1L).amount(10).build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(10, orderCreateDto.getAmount()),
                () -> assertEquals(1L, orderCreateDto.getBookId()),
                () -> assertEquals(1L, orderCreateDto.getCustomerId())
        );
    }
    @Test
    public void orderCreateDtoGetterSetter() {
        //
        // Given
        //
        OrderCreateDto orderCreateDto = new OrderCreateDto();
        orderCreateDto.setAmount(10);
        orderCreateDto.setBookId(1L);
        orderCreateDto.setCustomerId(1L);
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(10, orderCreateDto.getAmount()),
                () -> assertEquals(1L, orderCreateDto.getBookId()),
                () -> assertEquals(1L, orderCreateDto.getCustomerId())
        );
    }
}