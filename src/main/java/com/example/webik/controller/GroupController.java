package com.example.webik.controller;

import com.example.webik.models.Group;
import com.example.webik.models.Item;
import com.example.webik.service.GroupService;
import com.example.webik.service.dto.GroupDTO;
import com.example.webik.service.dto.ItemDTO;
import com.example.webik.service.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
        return ResponseEntity.of(groupService.getGroup(id));
    }


    @GetMapping("/search")
    public List<Group> findAllName(SearchCriteria criteria) {
        return groupService.findAll(criteria);
    }

    @GetMapping("/findAll")
    public List<Group> findAll(@RequestParam int offset, @RequestParam int limit) {

        return groupService.findAll(offset, limit);
    }

    @PostMapping
    public @ResponseBody
    GroupDTO create(@RequestBody @Valid GroupDTO groupDTO) {
        return groupService.create(groupDTO);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@RequestBody Group group,
                             @PathVariable Long id) {

        groupService.update(group);
        return group;
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.delete(id);
    }
}
