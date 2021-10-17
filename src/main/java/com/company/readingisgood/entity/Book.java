package com.company.readingisgood.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Transient
    public static final String SEQUENCE_NAME = "book_sequence";
    @Version
    private Long version;

    @Id
    private Long bookId;
    private Double price;
    private String name;
    private String author;
    private int amount;

}
