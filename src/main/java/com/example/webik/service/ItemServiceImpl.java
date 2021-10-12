package com.example.webik.service;

import com.example.webik.models.Item;
import com.example.webik.repository.ItemRepository;
import com.example.webik.service.dto.ItemDTO;
import com.example.webik.service.mapper.ItemDTOMapper;
import com.example.webik.service.specification.SearchCriteria;
import com.example.webik.service.specification.SpecCriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public ItemDTO create(ItemDTO item) {
        Item entity = ItemDTOMapper.mapToEntity(item);

        itemRepository.save(entity);

        return ItemDTOMapper.mapToDTO(entity).orElse(null);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public boolean delete(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);

        return true;
    }

    @Override
    public Optional<ItemDTO> getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);

        return ItemDTOMapper.mapToDTO(item.orElse(null));
    }

    @Override
    public List<ItemDTO> getAll() {
        return ItemDTOMapper.mapToDTOs(itemRepository.findAll());
    }


    @Override
    public List<ItemDTO> findByName(String name) {
        return ItemDTOMapper
                .mapToDTOs(itemRepository
                        .find(name, 300));
    }

    @Override
    public List<Item> findAll(String name, int offset, int limit) {
        PageRequest myPageable = new PageRequest(nameLike(name), offset, limit, Sort.by("id"));
        return itemRepository.findAll(myPageable).getContent();
    }

    @Override
    public List<Item> findAll(SearchCriteria searchCriteria) {
        Specification<Item> specification = getItemSearchSpecification(searchCriteria);
        Pageable myPageable = new PageRequest(specification, searchCriteria.getLimit(), searchCriteria.getOffset(), Sort.by("id"));
        return itemRepository.findAll(myPageable).getContent();
    }

    private Specification<Item> getItemSearchSpecification(SearchCriteria criteria) {
        return SpecCriteriaQuery.findItem(criteria);
    }

    @Override
    public List<Item> findAll(int offset, int limit) {
        PageRequest myPageable = new PageRequest(offset, limit, Sort.by("id"));
        return itemRepository.findAll(myPageable).getContent();
    }

    private Specification<Item> nameLike(String name) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
