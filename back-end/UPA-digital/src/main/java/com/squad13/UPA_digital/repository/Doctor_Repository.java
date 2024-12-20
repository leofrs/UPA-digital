package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import java.util.Optional;

public interface Doctor_Repository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByCrmAndPassword(String crm, String password);
    Optional<Doctor> findByCrm(String crm);





}
