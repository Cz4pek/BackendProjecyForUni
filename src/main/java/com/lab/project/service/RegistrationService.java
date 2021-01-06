package com.lab.project.service;

import com.lab.project.model.User;
import com.lab.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public void registerNewUser(User user){
        userRepository.save(user);
    }

}
