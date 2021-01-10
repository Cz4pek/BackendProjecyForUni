package com.lab.project.service;

import com.lab.project.model.User;
import com.lab.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;


    public boolean registerNewUser(User user){

        try {
            userRepository.save(user);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
