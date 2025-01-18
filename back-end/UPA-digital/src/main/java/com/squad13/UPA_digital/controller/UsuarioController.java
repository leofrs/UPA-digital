package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.request.LoginRequestDTO;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The UsuarioController class handles user login requests.
 * It provides an endpoint for user authentication.
 *
 * <h2>Endpoints</h2>
 * <ul>
 *   <li><b>POST /api/v1/login/login</b> - Authenticates a user with the provided credentials.</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * To use this controller, send a POST request to <code>/api/v1/login/login</code> with a JSON body containing the user's identifier and password.
 *
 * <h3>Example Request</h3>
 * <pre>
 * POST /api/v1/login/login
 * Content-Type: application/json
 * {
 *   "identifier": "user@example.com",
 *   "password": "password123"
 * }
 * </pre>
 *
 * <h3>Example Responses</h3>
 * <ul>
 *   <li><b>200 OK</b> - The user is successfully authenticated. The response body contains the authenticated user object.</li>
 *   <li><b>401 Unauthorized</b> - The provided credentials are invalid.</li>
 *   <li><b>500 Internal Server Error</b> - An unexpected error occurred on the server.</li>
 * </ul>
 *
 * <h2>Dependencies</h2>
 * This controller depends on the UserService class to handle the actual authentication logic.
 *
 * <h2>Cross-Origin Requests</h2>
 * This controller allows cross-origin requests from <code>http://localhost:5173</code>.
 *
 * <h2>Exception Handling</h2>
 * Any unexpected exceptions during the login process are caught and result in a 500 Internal Server Error response.
 */
@RestController
@RequestMapping("/api/v1/login")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> logar(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
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
