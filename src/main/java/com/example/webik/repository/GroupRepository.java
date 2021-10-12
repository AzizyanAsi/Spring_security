package com.example.webik.repository;

import com.example.webik.models.Group;
import com.example.webik.models.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group> {

        @Query("select g.name from Group g")
    Collection<? extends Group> findByName(@Param("name") String name);

}
