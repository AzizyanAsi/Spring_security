package com.example.webik.repository;


import com.example.webik.models.Group;
import com.example.webik.models.Item;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//@Component
public class ItemRepoImpl {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void attachItemToGroup(long itemId, long groupId) {
//        Item item = entityManager.find(Item.class, itemId);
//        Group group = entityManager.find(Group.class, groupId);
//
//        item.setName("Manually updated");
//
//        group.addItem(item);
//    }
//
////    public List<Item> findAllNames(String name, int offset, int limit) {
////        String q = "SELECT i FROM Item i WHERE i.name LIKE :name ORDER BY i.id";
////        TypedQuery<Item> query = entityManager.createQuery(q, Item.class);
////        query.setFirstResult(offset);
////        query.setMaxResults(limit);
////        return query.getResultList();
////    }
//
//
//    public Optional<Item> findById(Long id) {
//        Item item = entityManager.find(Item.class, id);
//        return Optional.ofNullable(item);
//    }
//
//
//    public Item insert(Item item) {
//
//        if (item.getItemDetail() != null) {
//            item.getItemDetail().setItem(item);
//        }
//        entityManager.persist(item);
//        return item;
//    }
//
//    public List<? extends Item> getAllItems() {
//
//
//        String q = "from Item i";
//        List<? extends Item> items = entityManager.createQuery(q, Item.class)
//                .getResultList();
//
//        return items;
//    }
//
//    public Item update(Item item) {
//        Item existing = entityManager.find(Item.class, item.getId());
//        existing.setName(item.getName());
//        existing.setPrice(item.getPrice());
//
//        return existing;
//    }
//
//    public boolean updateById(Long id) {//?
//
//        String q = "update item set item.name=:name " +
//                " where item.id = :id";
//        int updated = entityManager.createQuery(q)
//                .setParameter("id", id)
//                .executeUpdate();
//
//        return updated != 0;
//    }
//
//    public boolean delete(Item item) {
//        entityManager.remove(item);
//        return true;
//    }
//
//    public boolean deleteById(Long id) {
//
//        String q = "delete from Item i" +
//                " where i.id = :id";
//
//        int deleted = entityManager.createQuery(q)
//                .setParameter("id", id)
//                .executeUpdate();
//
//        return deleted != 0;
//    }
//
//    public List<Item> findItems(Predicate<Item> searchPredicate) {
//        return new ArrayList<>();
//    }
//

}
