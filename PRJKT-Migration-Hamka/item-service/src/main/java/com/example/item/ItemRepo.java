package com.example.item;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemRepo extends CrudRepository<ItemEntity, Long> {
    ItemEntity findByUuid(String uuid);
    List<ItemEntity> findAllByUuidIn(List<String> itemUuids);
}