package com.abworks.loginsessionmanager.domain.entitities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Role extends BaseEntity {
    private String roleName;

    @ManyToMany (mappedBy = "userRoles")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<User> usersWithRole;

}
