package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.request.LoginRequestDTO;
import com.squad13.UPA_digital.DTO.response.LoginResponseDTO;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/doctor")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/all-doctor")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = this.doctorRepository.findAll();
        if (!doctors.isEmpty()) {
            return ResponseEntity.ok(doctors);
        }
        return ResponseEntity.noContent().build();
    }
}
