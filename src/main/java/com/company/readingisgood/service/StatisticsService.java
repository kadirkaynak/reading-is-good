package com.company.readingisgood.service;

import com.company.readingisgood.dto.output.StatisticsOutputDto;

import java.util.List;

public interface StatisticsService {

    List<StatisticsOutputDto> getStatistics();

}
