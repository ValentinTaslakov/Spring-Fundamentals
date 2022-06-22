package com.example.demo.services;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entities.UserEntity;
import com.example.demo.models.mapper.UserMapper;
import com.example.demo.repositories.UserRepository;
import com.example.demo.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    private UserMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder, UserMapper mapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto){
        UserEntity newUser = mapper.userDtoToUserEntity(userRegisterDto);
        newUser.setPassword(passwordEncoder
                .encode(userRegisterDto.getPassword()));

        this.userRepository.save(newUser);
    }
}
