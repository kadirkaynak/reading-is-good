package com.company.readingisgood.mapper;

import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderCreateDto orderCreateDto);
    OrderOutputDto toOrderOutputDto(Order order);
    List<OrderOutputDto> toOrderDtoList(List<Order> order);

}
