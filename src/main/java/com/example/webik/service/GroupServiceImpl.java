package com.example.webik.service;

import com.example.webik.models.Group;
import com.example.webik.models.Item;
import com.example.webik.repository.GroupRepository;
import com.example.webik.service.dto.GroupDTO;
import com.example.webik.service.mapper.GroupDTOMapper;
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
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    @Transactional
    public GroupDTO create(GroupDTO group) {
        Group entity = GroupDTOMapper.mapToEntity(group);
        groupRepository.save(entity);
        return GroupDTOMapper.mapToDTO(entity).orElse(null);
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public boolean delete(Long id) {
        if (!groupRepository.existsById(id)) {
            return false;
        }
        groupRepository.deleteById(id);

        return true;
    }

    @Override
    public Optional<GroupDTO> getGroup(Long id) {
        Optional<Group> group = groupRepository.findById(id);

        return GroupDTOMapper.mapToDTO(group.orElse(null));
    }

    @Override
    public List<GroupDTO> getAll() {
        return GroupDTOMapper.mapToDTOs(groupRepository.findAll());
    }

    @Override
    public List<GroupDTO> findByName(String name) {
        return GroupDTOMapper
                .mapToDTOs(groupRepository
                        .findByName(name));
    }

    @Override
    public List<Group> findAll(SearchCriteria criteria) {
        Specification<Group> specification = getGroupSearchSpecification(criteria);
        Pageable myPageable = new PageRequest(specification, criteria.getLimit(), criteria.getOffset(), Sort.by("id"));
        return groupRepository.findAll(myPageable).getContent();
    }

    private Specification<Group> getGroupSearchSpecification(SearchCriteria criteria) {
        return SpecCriteriaQuery.findGroup(criteria);
    }

    @Override
    public List<Group> findAll(int offset, int limit) {
        PageRequest myPageable = new PageRequest(offset, limit, Sort.by("id"));
        return groupRepository.findAll(myPageable).getContent();
    }
}
