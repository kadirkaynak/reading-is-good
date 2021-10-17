package com.company.readingisgood.controller;

import com.company.readingisgood.dto.input.CustomerCreateDto;
import com.company.readingisgood.dto.output.CustomerOutputDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("/v1/customer")
public interface CustomerController {

    @PostMapping()
    ResponseEntity<CustomerOutputDto> createCustomer(@Valid @RequestBody CustomerCreateDto request);

    @GetMapping("/{customerId}")
    ResponseEntity<List<OrderOutputDto>> getOrdersById(@PathVariable Long customerId, @RequestParam int pageNumber, @RequestParam int pageSize);
}
