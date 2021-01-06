package com.lab.project.auth;

import com.google.common.collect.Lists;
import com.lab.project.model.User;
import com.lab.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.lab.project.security.AppUserRole.ADMIN;
import static com.lab.project.security.AppUserRole.USER;

@Repository("MySql")
public class MySqlAppUserService implements AppUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public MySqlAppUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> selectAppUserByUsername(String username) {

        return userRepository.findByUsername(username);
//                getApplicationUsers()
//                .stream()
//                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
//                .findFirst();
    }

    private List<AppUser> getApplicationUsers() {

        Iterable<User> users = userRepository.findAll();
        List<AppUser> applicationUsers = Lists.newArrayList(
                new AppUser(
                        "USER",
                        passwordEncoder.encode("password"),
                        "Jan@Pawel",
                        "Jan",
                        "Pawel",
                        USER.getGrantedRole(),
                        true,
                        true,
                        true,
                        true
                ),
                new AppUser(
                        "ADMIN",
                        passwordEncoder.encode("password"),
                        "Jan@Pawel",
                        "Jan",
                        "Pawel",
                        ADMIN.getGrantedRole(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
