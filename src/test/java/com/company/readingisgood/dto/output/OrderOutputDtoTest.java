package com.company.readingisgood.dto.output;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderOutputDtoTest {
    @Test
    public void orderOutputDtoBuilder() {
        //
        // Given
        //
        Date date = new Date();
        OrderOutputDto orderOutputDto = OrderOutputDto.builder().orderId(1L).bookId(1L).amount(10).createDate(date).customerId(1L).price(10.0).build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(1L, orderOutputDto.getOrderId()),
                () -> assertEquals(1L, orderOutputDto.getBookId()),
                () -> assertEquals(10, orderOutputDto.getAmount()),
                () -> assertEquals(date, orderOutputDto.getCreateDate()),
                () -> assertEquals(1L, orderOutputDto.getCustomerId()),
                () -> assertEquals(10.0, orderOutputDto.getPrice())
        );
    }
    @Test
    public void orderOutputDtoGetterSetter() {
        //
        // Given
        //
        Date date = new Date();
        OrderOutputDto orderOutputDto = new OrderOutputDto();
        orderOutputDto.setOrderId(1L);
        orderOutputDto.setBookId(1L);
        orderOutputDto.setCustomerId(1L);
        orderOutputDto.setCreateDate(date);
        orderOutputDto.setAmount(10);
        orderOutputDto.setPrice(10.0);
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals(1L, orderOutputDto.getOrderId()),
                () -> assertEquals(1L, orderOutputDto.getBookId()),
                () -> assertEquals(10, orderOutputDto.getAmount()),
                () -> assertEquals(date, orderOutputDto.getCreateDate()),
                () -> assertEquals(1L, orderOutputDto.getCustomerId()),
                () -> assertEquals(10.0, orderOutputDto.getPrice())
        );
    }
}