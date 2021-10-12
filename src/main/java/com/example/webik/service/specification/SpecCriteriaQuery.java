package com.example.webik.service.specification;

import com.example.webik.models.Group;
import com.example.webik.models.Item;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Path;
import java.util.ArrayList;
import java.util.List;


public class SpecCriteriaQuery {
    private static final String ATTRIBUTE_PATH_NAME = "name";
    private static final String ATTRIBUTE_PATH_PRICE = "price";


    private SpecCriteriaQuery() {
    }

    public static Specification<Item> findItem(SearchCriteria criteria) {
        return ((root, query, criteriaBuilder) -> getFindItemPredicate(root, criteriaBuilder, criteria));
    }

    public static Specification<Group> findGroup(SearchCriteria criteria) {
        return ((root, query, criteriaBuilder) -> getFindGroupPredicate(root, criteriaBuilder, criteria));
    }

    private static Predicate getFindGroupPredicate(Root<Group> root, CriteriaBuilder cb, SearchCriteria criteria) {
        List<Predicate> predicates = new ArrayList<>();

        if (!String.valueOf(criteria.getName()).isBlank()) {
            predicates.add(cb.like(cb.lower(root.get(ATTRIBUTE_PATH_NAME)),
                    cb.lower(cb.literal("%" + criteria.getName().trim() + "%"))));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }

    private static Predicate getFindItemPredicate(Root<Item> root, CriteriaBuilder cb, SearchCriteria criteria) {
        List<Predicate> predicates = new ArrayList<>();

        if (!String.valueOf(criteria.getName()).isBlank()) {
            predicates.add(cb.like(cb.lower(root.get(ATTRIBUTE_PATH_NAME)),
                    cb.lower(cb.literal("%" + criteria.getName().trim() + "%"))));
        }

        if (!String.valueOf(criteria.getPrice()).isBlank()) {
            Path<String> namePath = root.get(ATTRIBUTE_PATH_PRICE);
            predicates.add(cb.like(cb.lower(namePath),
                    cb.lower(cb.literal("%" + String.valueOf(criteria.getPrice()).trim() + "%"))));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }

}
