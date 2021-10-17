package com.company.readingisgood.service;

import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.entity.Order;

import java.text.ParseException;
import java.util.List;

public interface OrderService{

    Order saveOrder(Order order);
    List<OrderOutputDto> getOrdersById(Long customerId, int pageNumber, int pageSize);
    OrderOutputDto createOrder(OrderCreateDto request);
    OrderOutputDto getOrderById(Long orderId);
    List<OrderOutputDto> getOrders(String startDate, String endDate) throws ParseException;

}
