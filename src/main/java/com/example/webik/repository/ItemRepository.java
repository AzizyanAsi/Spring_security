package com.example.webik.repository;

import com.example.webik.models.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query("select i from Item i join fetch i.group" +
            " where lower(i.name) = lower(:name)" +
            " and i.price > :priceFrom")
    List<Item> find(@Param("name") String name, @Param("priceFrom") Integer priceFrom);

}