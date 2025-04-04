package com.example.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> list();
    Customer findByUsername(String username);
    void create(Customer customer);
}