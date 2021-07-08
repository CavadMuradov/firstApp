package com.example.firstapp.services;

import com.example.firstapp.models.Dto.UserDto;
import com.example.firstapp.models.Entity.UserEntity;
import com.example.firstapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }





    public void registerUser(UserDto userDto){
        if(userDto.getName().length()>3 && userDto.getLastname().length()>4) {
            UserEntity userEntity = new UserEntity(userDto);
            userRepository.save(userEntity);
        }

    }


}
