package com.company.readingisgood.controller.impl;

import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.service.CustomerService;
import com.company.readingisgood.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerImplTest {

    @InjectMocks
    private CustomerControllerImpl customerController;

    @Mock
    private OrderService orderService;
    @Mock
    private CustomerService customerService;

    @Test
    public void Given_Request_When_CreateCustomer_Then_ReturnCustomerOutputDto() {
        //
        // Given
        //
        CustomerOutputDto customerOutputDto = CustomerOutputDto.builder().customerId(1L).name("name").surname("surname").email("email@gmail.com").phone("0500000000").build();
        CustomerCreateDto customerCreateDto = CustomerCreateDto.builder().name("name").surname("surname").email("email@gmail.com").phone("0500000000").build();
        when(customerService.createCustomer(any(CustomerCreateDto.class))).thenReturn(customerOutputDto);
        //
        // When
        //
        ResponseEntity<CustomerOutputDto> customer = customerController.createCustomer(customerCreateDto);
        //
        // Then
        //
        Assertions.assertEquals(200, customer.getStatusCodeValue());
    }

    @Test
    public void Given_Id_When_GetOrdersById_Then_ReturnOrderOutputDto() {
        //
        // Given
        //
        List<OrderOutputDto> orderOutputDtoList = Arrays.asList(new OrderOutputDto());
        when(orderService.getOrdersById(0L, 1, 1)).thenReturn(orderOutputDtoList);
        //
        // When
        //
        ResponseEntity<List<OrderOutputDto>> orders = customerController.getOrdersById(0L, 1, 1);
        //
        // Then
        //
        Assertions.assertEquals(200, orders.getStatusCodeValue());
    }
}