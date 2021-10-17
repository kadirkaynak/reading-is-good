package com.company.readingisgood.dto.input;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderCreateDto {

    @NotNull(message = "BookId cannot be null")
    private Long bookId;
    @NotNull(message = "CustomerId cannot be null")
    private Long customerId;
    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount cannot not be less than {value}")
    @Max(value = 100, message = "Amount cannot not be grater than {value}")
    private int amount;

}
