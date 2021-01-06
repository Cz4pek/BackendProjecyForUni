package com.lab.project.auth;

import com.lab.project.model.User;
import com.lab.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private final AppUserDao appUserDao;

    @Autowired
    UserRepository userRepository;

    public AppUserService(@Qualifier("MySql") AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
        return user.map(AppUser::new).get();

//        return appUserDao
//                .selectAppUserByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
    }
}
