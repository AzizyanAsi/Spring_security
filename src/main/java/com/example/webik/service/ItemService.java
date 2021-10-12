package com.example.webik.service;

import com.example.webik.models.Item;
import com.example.webik.service.dto.ItemDTO;
import com.example.webik.service.specification.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    ItemDTO create(ItemDTO item);

    Item update(Item item);

    boolean delete(Long id);

    Optional<ItemDTO> getItem(Long id);

    List<ItemDTO> getAll();

    List<ItemDTO> findByName(String name);

    List<Item> findAll(String name, int offset, int limit);

    List<Item> findAll(SearchCriteria criteria);

    List<Item> findAll(int offset, int limit);

}
