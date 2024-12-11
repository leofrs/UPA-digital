package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository - serve para o spring reconhecer que essa interface é um repositório
// extends JpaRepository<classe modelo, tipo do ID> - serve para o repositório UsuarioRepository ter acesso a todas as
// funções do JpaRepository assim não precisamos criar as funções uma a uma.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByCpf(String cpf);

}
