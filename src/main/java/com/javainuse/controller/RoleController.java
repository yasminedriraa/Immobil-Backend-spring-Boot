package com.javainuse.controller;

import com.javainuse.model.Role;
import com.javainuse.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/roles")
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/roles/{roleId}")
    public ResponseEntity<?> getRoleById(@PathVariable("roleId") Long roleId) {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }

    @PutMapping("/roles/{roleId}")
    public ResponseEntity<?> updateRole(@PathVariable("roleId") Long roleId, @RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRole(roleId, role));
    }

    @DeleteMapping("/roles/{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId) {
        roleService.deleteRole(roleId);
    }
}
