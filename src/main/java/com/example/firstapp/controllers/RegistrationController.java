package com.example.firstapp.controllers;

import com.example.firstapp.models.Dto.UserDto;
import com.example.firstapp.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class RegistrationController {

     private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping(value ="/register")
    public ResponseEntity registerUser(@RequestBody UserDto userDto){
        try {
            registrationService.registerUser(userDto);
            return  new ResponseEntity("Welcome",HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }

    }


}
