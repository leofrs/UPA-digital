package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorAndDate(Doctor doctor, LocalDateTime date);

    boolean existsByDoctorAndDateBetween(Doctor doctor, LocalDateTime startRange, LocalDateTime endRange);
}
