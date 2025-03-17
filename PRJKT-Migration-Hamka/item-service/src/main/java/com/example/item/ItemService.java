package com.example.item;

import java.util.List;

public interface ItemService {
    List<Item> list();
    Item findByUuid(String uuid);
    Item create(Item item);
}