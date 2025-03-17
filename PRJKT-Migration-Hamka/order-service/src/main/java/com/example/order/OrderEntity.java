package com.example.order;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    private String username;

    @ElementCollection
    private List<String> items;
}