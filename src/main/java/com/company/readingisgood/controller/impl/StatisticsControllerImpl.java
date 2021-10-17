package com.company.readingisgood.controller.impl;

import com.company.readingisgood.controller.StatisticsController;
import com.company.readingisgood.dto.output.StatisticsOutputDto;
import com.company.readingisgood.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatisticsControllerImpl implements StatisticsController {

    private final StatisticsService statisticsService;

    /**
     * Handles the incoming GET request
     *
     * @return StatisticsOutputDto
     */
    @Override
    public ResponseEntity<List<StatisticsOutputDto>> getStatistics(){
        return new ResponseEntity<>(statisticsService.getStatistics(), HttpStatus.OK);
    }
}
