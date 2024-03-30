package dev.rishabh.userservice.services;

import dev.rishabh.userservice.dtos.UserDto;
import dev.rishabh.userservice.models.Role;
import dev.rishabh.userservice.models.User;
import dev.rishabh.userservice.repositories.RoleRepository;
import dev.rishabh.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserDto getUserDetails(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return null;
        }
        return UserDto.from(userOptional.get());
    }

    public UserDto setUserRoles(Long userId, List<Long> roleIds) {
        Optional<User> userOptional = userRepository.findById(userId);
        List<Role> roles = roleRepository.findAllByIdIn(roleIds);
        if (userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
        user.setRoles(Set.copyOf(roles));
        User savedUser = userRepository.save(user);
        return UserDto.from(savedUser);
    }
}
