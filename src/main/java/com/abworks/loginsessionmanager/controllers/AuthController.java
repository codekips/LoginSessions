package com.abworks.loginsessionmanager.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/index")
    public String getHome(){
        return "home_index";
    }


}
