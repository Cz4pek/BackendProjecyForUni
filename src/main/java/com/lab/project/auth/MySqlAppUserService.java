package com.lab.project.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("MySql")
public class MySqlAppUserService implements AppUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MySqlAppUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectAppUserByUsername(String username) {
        return Optional.empty();
    }
}
