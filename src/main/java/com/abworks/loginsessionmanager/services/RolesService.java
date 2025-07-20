package com.abworks.loginsessionmanager.services;

import com.abworks.loginsessionmanager.domain.entitities.Role;
import com.abworks.loginsessionmanager.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesService {
    private final RoleRepository roleRepository;
    public static final String DEFAULT_ROLE = "BASIC";

    public Optional<Role> matchRole(final String roleName) {
        if (Objects.isNull(roleName) || roleName.isEmpty())
            return Optional.empty();
        String roleWithSuffix = roleName.endsWith("_ROLE") ? roleName : roleName + "_ROLE";
        return roleRepository.getRoleByRoleName(roleWithSuffix);
    }
}
