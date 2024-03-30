package dev.rishabh.userservice.services;

import dev.rishabh.userservice.models.Role;
import dev.rishabh.userservice.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role createRole(String name) {
        Role role = new Role();
        role.setRole(name);

        return roleRepository.save(role);
    }
}
