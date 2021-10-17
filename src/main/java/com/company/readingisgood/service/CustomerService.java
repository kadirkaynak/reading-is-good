package com.company.readingisgood.service;

import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.entity.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    CustomerOutputDto createCustomer(CustomerCreateDto request);

}
