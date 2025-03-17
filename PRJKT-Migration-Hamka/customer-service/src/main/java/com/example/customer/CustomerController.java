package com.example.customer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> list() {
        return customerService.list();
    }

    @GetMapping("/{username}")
    public Customer findByUsername(@PathVariable String username) {
        return customerService.findByUsername(username);
    }

    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerService.create(customer);
    }
}