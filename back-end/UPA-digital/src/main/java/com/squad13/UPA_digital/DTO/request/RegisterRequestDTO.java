package com.squad13.UPA_digital.DTO.request;

import com.squad13.UPA_digital.utils.UserRole;
import lombok.Getter;

@Getter
public class RegisterRequestDTO {
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
