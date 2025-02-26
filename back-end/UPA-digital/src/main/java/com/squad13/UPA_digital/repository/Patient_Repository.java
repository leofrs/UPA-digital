package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Patient_Repository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByCartSusNumAndPassword(String cartSusNum, String password);
    
}
