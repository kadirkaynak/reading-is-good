package com.company.readingisgood.repository;

import com.company.readingisgood.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
    boolean existsByEmail(String email);
}
