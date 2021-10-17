package com.company.readingisgood.repository;

import com.company.readingisgood.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
