package com.squad13.UPA_digital.utils;

public enum UserRole {
    ADMIN("admin"),
    PATIENT("patient"),
    DOCTOR("doctor");


    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
