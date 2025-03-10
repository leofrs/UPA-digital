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

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

@PostMapping("/login")
public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO){
    User user = (User) this.userRepository.findByEmail(requestDTO.getEmail());
    if(passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())) {
        String token = this.tokenService.generateToken(user);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    return ResponseEntity.badRequest().build();
 }

}
