package com.lab.project.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.lab.project.security.AppUserPermission.*;

public enum AppUserRole {
    USER(Sets.newHashSet(FORM_READ, FORM_WRITE, USERPROFILE_READ, USERPROFILE_WRITE)),
    ADMIN(Sets.newHashSet(ADMINPROFILE_READ, ADMINPROFILE_WRITE, FORM_READ, FORM_WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permission =
                getPermissions()
                        .stream()
                        .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                        .collect(Collectors.toSet());
        permission.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permission;
    }

    public Set<SimpleGrantedAuthority> getGrantedRole() {
        Set<SimpleGrantedAuthority> permission = new HashSet<>();
        permission.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
       // System.out.println("ROLE_" + this.name());
        return permission;

    }
}