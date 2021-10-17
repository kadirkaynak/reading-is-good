package com.company.readingisgood.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookOutputDto {

    private Long bookId;
    private Double price;
    private String name;
    private String author;
    private int amount;

}
