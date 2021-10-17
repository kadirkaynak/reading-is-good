package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.entity.Customer;
import com.company.readingisgood.mapper.CustomerMapper;
import com.company.readingisgood.repository.CustomerRepository;
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
public class CustomerServiceImplTest {
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private SequenceGeneratorService sequenceGenerator;

    private Customer customer;

    @BeforeEach
    public void setUp(){
        customer = Customer.builder().customerId(1L).name("name").surname("surname").email("email@gmail.com").phone("05000000000").build();
    }

    @Test
    public void Given_Customer_When_SaveCustomer_Then_ReturnCustomer() {
        //
        // Given
        //
        when(customerRepository.save(customer)).thenReturn(customer);
        //
        // When
        //
        Customer saveCustomer = customerService.saveCustomer(customer);
        //
        // Then
        //
        Assertions.assertEquals(customer, saveCustomer);
    }

    @Test
    public void Given_Request_When_CreateCustomer_Then_ReturnCustomerOutputDto() {
        //
        // Given
        //
        CustomerCreateDto customerCreateDto = CustomerCreateDto.builder().name("name").surname("surname").email("email@gmail.com").phone("05000000000").build();
        CustomerOutputDto customerOutputDto = CustomerOutputDto.builder().customerId(1L).name("name").surname("surname").email("email@gmail.com").phone("05000000000").build();
        when(customerRepository.save(customer)).thenReturn(customer);
        when(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME)).thenReturn(1L);
        when(customerMapper.toCustomer(any(CustomerCreateDto.class))).thenReturn(customer);
        when(customerMapper.toCustomerOutputDto(any(Customer.class))).thenReturn(customerOutputDto);
        //
        // When
        //
        CustomerOutputDto saveCustomer = customerService.createCustomer(customerCreateDto);
        //
        // Then
        //
        Assertions.assertEquals(customer.getCustomerId(), saveCustomer.getCustomerId());
    }
}