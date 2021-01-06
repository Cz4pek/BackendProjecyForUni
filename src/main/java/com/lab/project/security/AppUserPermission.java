package com.lab.project.security;

public enum AppUserPermission {

    USERPROFILE_READ("userprofile:read"),
    USERPROFILE_WRITE("userprofile:write"),
    ADMINPROFILE_READ("adminprofile:read"),
    ADMINPROFILE_WRITE("adminprofile:write"),
    FORM_READ("from:read"),
    FORM_WRITE("from:write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
