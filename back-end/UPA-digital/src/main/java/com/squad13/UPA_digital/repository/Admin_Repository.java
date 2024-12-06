package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Admin_Repository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByCpf(String cpf);
    Optional<Admin> findByEmailAndCpf(String email, String cpf);
    
}
