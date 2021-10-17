package com.company.readingisgood.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StatisticsOutputDto {

    private String month;
    private int amount;
    private Double price;

}
