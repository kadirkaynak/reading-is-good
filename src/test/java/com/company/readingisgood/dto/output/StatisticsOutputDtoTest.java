package com.company.readingisgood.dto.output;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StatisticsOutputDtoTest {
    @Test
    public void StatisticsOutputDtoBuilder() {
        //
        // Given
        //
        StatisticsOutputDto statisticsOutputDto = StatisticsOutputDto.builder().month("MAY").amount(10).price(10.0).build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("MAY", statisticsOutputDto.getMonth()),
                () -> assertEquals(10.0, statisticsOutputDto.getPrice()),
                () -> assertEquals(10, statisticsOutputDto.getAmount())
        );
    }
    @Test
    public void StatisticsOutputDtoGetterSetter() {
        //
        // Given
        //
        StatisticsOutputDto statisticsOutputDto = new StatisticsOutputDto();
        statisticsOutputDto.setAmount(10);
        statisticsOutputDto.setMonth("MAY");
        statisticsOutputDto.setPrice(10.0);
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("MAY", statisticsOutputDto.getMonth()),
                () -> assertEquals(10.0, statisticsOutputDto.getPrice()),
                () -> assertEquals(10, statisticsOutputDto.getAmount())
        );
    }
}