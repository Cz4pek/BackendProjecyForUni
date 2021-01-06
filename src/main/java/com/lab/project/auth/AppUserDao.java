package com.lab.project.auth;

import com.lab.project.model.User;

import java.util.Optional;

public interface AppUserDao {

    Optional<User> selectAppUserByUsername(String username);

}
