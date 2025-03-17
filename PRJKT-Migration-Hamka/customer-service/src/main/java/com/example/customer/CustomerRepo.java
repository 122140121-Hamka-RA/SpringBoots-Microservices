package com.example.customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByUsername(String username);
}