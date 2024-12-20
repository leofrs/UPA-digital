package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.request.LoginRequestDTO;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/login")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> logar(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        System.out.println("Recebido paciente:");
        try {
            // Autentica o usuário
            Optional<? extends User> user = (userService.login(
                    loginRequestDTO.getIdentifier(),
                    loginRequestDTO.getPassword()
            ));
            // Verifica se o login foi bem-sucedido
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get()); // Retorna o usuário autenticado
            } else {
                return ResponseEntity.status(401).body("Credenciais inválidas");
            }
        } catch (Exception e) {
            // Trata erros inesperados
            return ResponseEntity.status(500).body("Erro interno do servidor");
        }
    }
}
