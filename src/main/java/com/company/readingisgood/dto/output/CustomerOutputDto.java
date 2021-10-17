package com.company.readingisgood.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerOutputDto {

    private Long customerId;
    private String name;
    private String surname;
    private String email;
    private String phone;

}
