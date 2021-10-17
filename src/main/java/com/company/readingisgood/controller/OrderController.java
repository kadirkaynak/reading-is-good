package com.company.readingisgood.controller;

import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Validated
@RequestMapping("/v1/order")
public interface OrderController {

    @PostMapping
    ResponseEntity<OrderOutputDto> createOrder(@Valid @RequestBody OrderCreateDto request);

    @GetMapping("/{orderId}")
    ResponseEntity<OrderOutputDto> getOrderById(@PathVariable Long orderId);

    @GetMapping()
    ResponseEntity<List<OrderOutputDto>> getOrders(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException;
}
