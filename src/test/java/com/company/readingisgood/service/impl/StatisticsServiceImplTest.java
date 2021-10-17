package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.output.StatisticsOutputDto;
import com.company.readingisgood.entity.Order;
import com.company.readingisgood.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceImplTest {

    @InjectMocks
    private StatisticsServiceImpl statisticsService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void Given_When_GetStatistics_Then_ReturnStatisticsOutputDtoList() {
        //
        // Given
        //
        Order order = Order.builder().orderId(1L).createDate(new Date()).customerId(1L).bookId(1L).amount(10).price(10.0).build();
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));
        //
        // When
        //
        List<StatisticsOutputDto> statistics = statisticsService.getStatistics();
        //
        // Then
        //
        Assertions.assertNotEquals(0, statistics.size());
    }

}