package com.company.readingisgood.repository;

import com.company.readingisgood.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Long> {
    List<Order> findAllByCustomerId(Long customerId, Pageable pageable);
    List<Order> findByCreateDateBetween(Date startDate, Date endDate);
}
