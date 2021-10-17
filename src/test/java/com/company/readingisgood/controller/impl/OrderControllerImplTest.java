package com.company.readingisgood.controller.impl;

import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderControllerImplTest {

    @InjectMocks
    private OrderControllerImpl orderController;

    @Mock
    private OrderService orderService;

    @Test
    public void Given_Request_When_CreateOrder_Then_ReturnOrderOutputDto() {
        //
        // Given
        //
        OrderCreateDto orderCreateDto = OrderCreateDto.builder().bookId(0L).build();
        OrderOutputDto orderOutputDto = OrderOutputDto.builder().bookId(0L).orderId(0L).build();
        when(orderService.createOrder(any(OrderCreateDto.class))).thenReturn(orderOutputDto);
        //
        // When
        //
        ResponseEntity<OrderOutputDto> order = orderController.createOrder(orderCreateDto);
        //
        // Then
        //
        Assertions.assertEquals(200, order.getStatusCodeValue());
    }

    @Test
    public void Given_Id_When_GetOrderById_Then_ReturnOrderOutputDto() {
        //
        // Given
        //
        OrderOutputDto orderOutputDto = OrderOutputDto.builder().bookId(0L).orderId(0L).build();
        when(orderService.getOrderById(0L)).thenReturn(orderOutputDto);
        //
        // When
        //
        ResponseEntity<OrderOutputDto> order = orderController.getOrderById(0L);
        //
        // Then
        //
        Assertions.assertEquals(200, order.getStatusCodeValue());
    }


    @Test
    public void Given_Dates_When_GetOrders_Then_ReturnOrderOutputDtoList() throws ParseException {
        //
        // Given
        //
        String startDate = "01-01-2021";
        String endDate = "01-01-2021";
        List<OrderOutputDto> orderOutputDtoList = Arrays.asList(OrderOutputDto.builder().bookId(0L).orderId(0L).build());
        when(orderService.getOrders(startDate, endDate)).thenReturn(orderOutputDtoList);
        //
        // When
        //
        ResponseEntity<List<OrderOutputDto>> order = orderController.getOrders(startDate, endDate);
        //
        // Then
        //
        Assertions.assertEquals(200, order.getStatusCodeValue());
    }
}