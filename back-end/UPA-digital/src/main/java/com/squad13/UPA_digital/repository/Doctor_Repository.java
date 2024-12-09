package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Doctor_Repository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByCrm(String crm);
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByCpf(String cpf);
    Optional<Doctor> findByCrmAndEmail(String crm, String email);
    Optional<Doctor> findByCrmAndCpf(String crm, String cpf);
    Optional<Doctor> findByEmailAndCpf(String email, String cpf);
    Optional<Doctor> findByCrmAndEmailAndCpf(String crm, String email, String cpf);
}
