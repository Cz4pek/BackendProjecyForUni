package com.lab.project.auth;

import com.google.common.collect.Lists;
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
    public MySqlAppUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectAppUserByUsername(String username) {

        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getApplicationUsers() {
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
