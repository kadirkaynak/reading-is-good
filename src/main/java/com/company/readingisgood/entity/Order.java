package com.company.readingisgood.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "orders")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "order_sequence";

    @Id
    private Long orderId;
    private Date createDate;
    private Long bookId;
    private Long customerId;
    private int amount;
    private Double price;

}
