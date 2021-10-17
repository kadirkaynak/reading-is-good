package com.company.readingisgood.controller.impl;

import com.company.readingisgood.controller.CustomerController;
import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.service.CustomerService;
import com.company.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    /**
     * Handles the incoming POST request
     *
     * @param request fields of CustomerCreateDto to be added
     * @return CustomerOutputDto
     */
    @Override
    public ResponseEntity<CustomerOutputDto> createCustomer(@Valid @RequestBody CustomerCreateDto request){
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.OK);
    }

    /**
     * Handles the incoming GET request "/pageable"
     *
     * @param pageNumber of the page to be listed
     * @param pageSize of the page to be listed
     * @return OrderOutputDto on the page
     */
    @Override
    public ResponseEntity<List<OrderOutputDto>> getOrdersById(@PathVariable Long customerId, @RequestParam int pageNumber, @RequestParam int pageSize){
        return new ResponseEntity<>(orderService.getOrdersById(customerId, pageNumber, pageSize), HttpStatus.OK);
    }
}
