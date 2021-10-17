package com.company.readingisgood.mapper;

import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerCreateDto customerCreateDto);
    CustomerOutputDto toCustomerOutputDto(Customer customer);

}
