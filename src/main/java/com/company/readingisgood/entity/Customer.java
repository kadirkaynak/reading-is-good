package com.company.readingisgood.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";

    @Id
    private Long customerId;
    private String name;
    private String surname;
    private String email;
    private String phone;

}
