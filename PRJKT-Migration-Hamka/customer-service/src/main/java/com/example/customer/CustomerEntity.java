package com.example.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}