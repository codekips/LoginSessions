package com.abworks.loginsessionmanager.repositories;

import com.abworks.loginsessionmanager.domain.entitities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> getRoleByRoleName(String roleName);

}
