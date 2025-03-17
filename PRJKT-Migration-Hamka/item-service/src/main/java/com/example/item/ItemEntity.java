package com.example.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    private String type;
    private String name;
    private BigDecimal price;
    private String description;
}