package com.example.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity, Long> {
    OrderEntity findByUuid(String uuid);
}