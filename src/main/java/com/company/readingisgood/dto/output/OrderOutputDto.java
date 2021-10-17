package com.company.readingisgood.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderOutputDto {

    private Long orderId;
    private Date createDate;
    private Long bookId;
    private Long customerId;
    private int amount;
    private Double price;

}
