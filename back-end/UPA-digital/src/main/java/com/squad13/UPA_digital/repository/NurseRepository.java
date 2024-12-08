package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    Optional<Nurse> findByCoremAndPassword(String corem, String password);
}
