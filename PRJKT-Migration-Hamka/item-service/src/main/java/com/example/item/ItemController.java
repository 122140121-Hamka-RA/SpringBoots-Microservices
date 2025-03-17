package com.example.item;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> list() {
        return itemService.list();
    }

    @GetMapping("/{uuid}")
    public Item findByUuid(@PathVariable String uuid) {
        return itemService.findByUuid(uuid);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return itemService.create(item);
    }
}