package com.company.readingisgood.controller.impl;

import com.company.readingisgood.dto.output.StatisticsOutputDto;
import com.company.readingisgood.service.StatisticsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsControllerImplTest {
    @InjectMocks
    private StatisticsControllerImpl statisticsController;

    @Mock
    private StatisticsService statisticsService;

    @Test
    public void Given_Request_When_CreateOrder_Then_ReturnOrderOutputDto() {
        //
        // Given
        //
        StatisticsOutputDto statisticsOutputDto = StatisticsOutputDto.builder().month("MAY").amount(10).price(10.0).build();
        when(statisticsService.getStatistics()).thenReturn(Arrays.asList(statisticsOutputDto));
        //
        // When
        //
        ResponseEntity<List<StatisticsOutputDto>> statistics = statisticsController.getStatistics();
        //
        // Then
        //
        Assertions.assertEquals(200, statistics.getStatusCodeValue());
    }
}