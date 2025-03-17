package com.example.order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }

    @GetMapping("/{uuid}")
    public Order findByUuid(@PathVariable String uuid) {
        return orderService.findByUuid(uuid);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }
}