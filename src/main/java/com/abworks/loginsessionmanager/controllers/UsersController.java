package com.abworks.loginsessionmanager.controllers;

import com.abworks.loginsessionmanager.domain.dto.UserRegistrationDTO;
import com.abworks.loginsessionmanager.domain.entitities.User;
import com.abworks.loginsessionmanager.domain.mappers.UserRegistrationMapper;
import com.abworks.loginsessionmanager.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {


    private final UserRegistrationMapper userRegistrationMapper;

    private final UserService userService;

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User incomingUser = userRegistrationMapper.convert(userRegistrationDTO);
        userService.addUserWithRoles(incomingUser, userRegistrationDTO.getRoles());
    }
}
