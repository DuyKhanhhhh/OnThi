package com.example.onthiapib1.service.imlp;

import com.example.onthiapib1.model.Role;
import com.example.onthiapib1.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
