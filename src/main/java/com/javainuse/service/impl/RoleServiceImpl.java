package com.javainuse.service.impl;

import com.javainuse.model.Role;
import com.javainuse.repository.RoleRepository;
import com.javainuse.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role roleToUpdate = roleRepository.findById(id).get();
        roleToUpdate.setId(role.getId());
        roleToUpdate.setName(role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
