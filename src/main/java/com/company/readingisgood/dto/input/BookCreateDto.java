package com.company.readingisgood.dto.input;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookCreateDto {

    @Min(value = 0, message = "Price cannot be less than {value}")
    private Double price;
    @NotNull(message = "Name cannot be null")
    @Length(min = 1, max = 100, message = "Name length should be between {min} and {max}")
    private String name;
    @NotNull(message = "Author cannot be null")
    @Length(min = 1, max = 100, message = "Name length should be between {min} and {max}")
    private String author;

}
