package com.squad13.UPA_digital.DTO.response;

import com.squad13.UPA_digital.utils.UserRole;

public class RegisterResponseDTO {
    private Long id;
    private String email;
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
