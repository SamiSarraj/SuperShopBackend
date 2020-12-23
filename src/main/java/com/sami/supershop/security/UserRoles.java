package com.sami.supershop.security;

public enum UserRoles {
    ADMIN("Admin"),
    USER("User");

    private final String userRole;

    private UserRoles(final String userRole) {
        this.userRole = userRole;
    }

    public String getUser() {
        return userRole;
    }
}
