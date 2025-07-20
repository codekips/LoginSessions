package com.abworks.loginsessionmanager.domain.dto;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter
public class UserRegistrationDTO {
    @Nonnull
    private String name;
    @Nonnull
    private String email;
    @Nonnull
    private String password;
    private List<String> roles = new ArrayList<>();
}
