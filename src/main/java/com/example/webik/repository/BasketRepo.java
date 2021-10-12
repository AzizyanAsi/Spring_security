package com.example.webik.repository;

import com.example.webik.models.Basket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
@Component
public class BasketRepo {

    @PersistenceContext
    private EntityManager entityManager;

//    private final SessionFactory sessionFactory;
//    @Autowired
//    public BasketRepo(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


    public Optional<Basket> getBasket(Long basketId) {
        Basket basket = entityManager
                .createQuery("select b from Basket b" +
                        " where b.id = 1", Basket.class)
                .getSingleResult();

        return Optional.ofNullable(basket);
    }
}
