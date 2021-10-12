package com.example.webik.service;

import com.example.webik.models.Group;
import com.example.webik.models.Item;
import com.example.webik.service.dto.GroupDTO;

import com.example.webik.service.specification.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    GroupDTO create(GroupDTO group);

    Group update(Group group);

    boolean delete(Long id);

    Optional<GroupDTO> getGroup(Long id);

    List<GroupDTO> getAll();

    List<GroupDTO> findByName(String name);

    List<Group> findAll(SearchCriteria criteria);

    List<Group> findAll(int offset, int limit);

}
