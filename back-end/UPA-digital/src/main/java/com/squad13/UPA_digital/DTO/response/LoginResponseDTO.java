package com.squad13.UPA_digital.DTO.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String token;
    private String email;
    private String role;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
