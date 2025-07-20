package com.abworks.loginsessionmanager.domain.mappers;

import com.abworks.loginsessionmanager.domain.dto.UserRegistrationDTO;
import com.abworks.loginsessionmanager.domain.entitities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@RequiredArgsConstructor
public class UserRegistrationMapper {

    private final PasswordEncoder passwordEncoder;
    public User convert(UserRegistrationDTO sourceDTO){
        User user = User.builder()
                .name(sourceDTO.getName())
                .password(passwordEncoder.encode(sourceDTO.getPassword()))
                .email(sourceDTO.getEmail()).build();
        return user;

    }

}
