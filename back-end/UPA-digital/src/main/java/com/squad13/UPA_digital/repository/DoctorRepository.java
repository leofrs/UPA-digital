package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByEmail(String email);
    List<Doctor> findAll();
}
