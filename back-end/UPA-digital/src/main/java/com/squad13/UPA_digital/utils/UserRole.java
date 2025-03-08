package com.squad13.UPA_digital.utils;

public enum UserRole {
    ADMIN("admin"),
    PATIENT("patient"),
    RECEPTIONIST("Receptionist");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
