package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Pacient_Repository extends JpaRepository<Pacient, Long> {
    Optional<Pacient> findByCartSusNumAndPassword(String cartSusNum, String password);
}
