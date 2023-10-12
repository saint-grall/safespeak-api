package com.safespeak.demo.enums;

public enum UserRole {
    USER_ROLE("User"),
    MANAGER_ROLE("Manager");
    private final String label;

    UserRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
