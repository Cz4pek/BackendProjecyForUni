package com.lab.project.service;

import com.lab.project.auth.AppUser;
import com.lab.project.model.ChangedUserInfo;
import com.lab.project.model.User;
import com.lab.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPageService {

    @Autowired
    UserRepository userRepository;

    private Optional<User> getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> userCheck  = userRepository.findByUsername(
                ((AppUser)auth.getPrincipal())
                        .getUsername());
        userCheck.orElseThrow(() ->new UsernameNotFoundException("Nie ma zalogowanego użytkownika"));
        return userCheck;
    }

    public User getUserPage(){
        Optional<User> userCheck = getLoggedInUser();
        return userCheck.get();
    }

    public void changeUsersInfo(ChangedUserInfo changedUserInfo){

        Optional<User> userCheck = getLoggedInUser();
        User user = userCheck.get();
        String temp = changedUserInfo.getFirstname();
        if(temp != null) user.setFirstname(temp);
        temp = changedUserInfo.getLastname();
        if(temp != null) user.setLastname(temp);
        temp = changedUserInfo.getEmail();
        if(temp != null) user.setEmail(temp);

        userRepository.save(user);
//        Optional<User> userCheck = getLoggedInUser();
//        userCheck.get();
    }


}
