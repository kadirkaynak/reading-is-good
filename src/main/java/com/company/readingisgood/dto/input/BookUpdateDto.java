package com.company.readingisgood.dto.input;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookUpdateDto {

    @Min(value = 0, message = "Amount should not be less than {value}")
    @NotNull(message = "Amount cannot be null")
    private int amount;

}
