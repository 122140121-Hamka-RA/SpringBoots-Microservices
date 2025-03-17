package com.example.order;

import java.util.List;

public interface OrderService {
    List<Order> list();
    Order findByUuid(String uuid);
    Order create(Order order);
}