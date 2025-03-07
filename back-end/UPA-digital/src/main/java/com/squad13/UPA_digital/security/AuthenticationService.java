package com.squad13.UPA_digital.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

public class AuthenticationService {
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
