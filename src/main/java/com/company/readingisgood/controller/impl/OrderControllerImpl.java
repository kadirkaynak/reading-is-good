package com.company.readingisgood.controller.impl;

import com.company.readingisgood.controller.OrderController;
import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    /**
     * Handles the incoming POST request
     *
     * @param request fields of order to be added
     * @return OrderOutputDto
     */
    @Override
    public ResponseEntity<OrderOutputDto> createOrder(@Valid @RequestBody OrderCreateDto request){
        return new ResponseEntity<>(orderService.createOrder(request), HttpStatus.OK);
    }

    /**
     * Handles the incoming GET request "/{orderId}"
     *
     * @param orderId of the order to be retrieved
     * @return OrderOutputDto
     */
    @Override
    public ResponseEntity<OrderOutputDto> getOrderById(@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    /**
     * Handles the incoming GET request
     *
     * @param startDate of the date field to be listed
     * @param endDate of the date field to be listed
     * @return OrderOutputDto
     * @throws ParseException
     */
    @Override
    public ResponseEntity<List<OrderOutputDto>> getOrders(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException {
        return new ResponseEntity<>(orderService.getOrders(startDate, endDate), HttpStatus.OK);
    }
}
