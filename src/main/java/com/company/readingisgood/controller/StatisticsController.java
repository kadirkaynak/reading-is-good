package com.company.readingisgood.controller;

import com.company.readingisgood.dto.output.StatisticsOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@RequestMapping("/v1/statistics")
public interface StatisticsController {

    @GetMapping()
    ResponseEntity<List<StatisticsOutputDto>> getStatistics();
}
