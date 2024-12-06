package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Usuario;
import com.squad13.UPA_digital.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

// @Service para o springboot reconhecer que essa classe é uma service do projeto
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public boolean logar(String cpf, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByCpf(cpf);
        if(usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return true;
        } else {
            return false;
        }
    }
}
