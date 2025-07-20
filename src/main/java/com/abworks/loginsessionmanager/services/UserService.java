package com.abworks.loginsessionmanager.services;

import com.abworks.loginsessionmanager.domain.entitities.Role;
import com.abworks.loginsessionmanager.domain.entitities.User;
import com.abworks.loginsessionmanager.repositories.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.abworks.loginsessionmanager.services.RolesService.DEFAULT_ROLE;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RolesService rolesService;
    public void addUser(User newUser){
        addUserWithRoles(newUser, new ArrayList<>( ));
    }
    @Transactional
    public void addUserWithRoles(@NotNull User newUser, final List<String> roles) {
        if (exists(newUser))
            throw new IllegalArgumentException("A user with this email already exists");

        final Set<String> uniqueRoleNames = new HashSet<>(roles);

        if (uniqueRoleNames.isEmpty())
            uniqueRoleNames.add(DEFAULT_ROLE);
        final Set<Role> requestedRoles = uniqueRoleNames.stream()
                .map(rolesService::matchRole)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toSet());
        newUser.setUserRoles(requestedRoles);
        userRepository.save(newUser);
    }

    private boolean exists(User newUser) {
        return userRepository.getUserByEmail(newUser.getEmail()).isPresent();
    }

}
