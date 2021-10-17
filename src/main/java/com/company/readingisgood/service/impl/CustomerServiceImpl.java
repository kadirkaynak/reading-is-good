package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.entity.Customer;
import com.company.readingisgood.exception.CustomerExistException;
import com.company.readingisgood.mapper.CustomerMapper;
import com.company.readingisgood.repository.CustomerRepository;
import com.company.readingisgood.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info(String.format("Date=%s|Request=%s",new Date(), customer.toString()));
        return customerRepository.save(customer);
    }

    @Override
    public CustomerOutputDto createCustomer(CustomerCreateDto request){
        if(customerRepository.existsByEmail(request.getEmail()))
            throw new CustomerExistException("Customer already exist by email: " + request.getEmail());
        Customer customer = customerMapper.toCustomer(request);
        customer.setCustomerId(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME));
        return customerMapper.toCustomerOutputDto(saveCustomer(customer));
    }

}
