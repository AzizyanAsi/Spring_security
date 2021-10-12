package com.example.webik.service.mapper;

import com.example.webik.models.Group;
import com.example.webik.service.dto.GroupDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class GroupDTOMapper {
    public static List<GroupDTO> mapToDTOs(Collection<? extends Group> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }

        List<GroupDTO> groupDTOS = new ArrayList<>();

        for (Group entity : entities) {
            groupDTOS.add(mapToDTO(entity).orElse(null));
        }

        return groupDTOS;
    }

    public static Optional<GroupDTO> mapToDTO(Group entity) {
        if (entity == null) {
            return Optional.empty();
        }

        GroupDTO dto = new GroupDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());


        return Optional.of(dto);
    }

    public static Group mapToEntity(GroupDTO dto) {
        if (dto == null) {
            return null;
        }

        Group entity = new Group();
        entity.setName(dto.getName());

        return entity;
    }
}
