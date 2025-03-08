package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.request.LoginRequestDTO;
import com.squad13.UPA_digital.DTO.response.LoginResponseDTO;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.UserRepository;
import com.squad13.UPA_digital.security.TokenService;
import com.squad13.UPA_digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173/")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        //TODO: ARRUMAR ISSO E MANDAR PARA A SERVICE!!!
        User user = (User) this.userRepository.findByEmail(body.getEmail());
        if(passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        return ResponseEntity.badRequest().build();
    }

}
