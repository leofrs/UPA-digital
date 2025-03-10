package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.DoctorRepository;
import com.squad13.UPA_digital.repository.PatientRepository;
import com.squad13.UPA_digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Patient addPatient(Patient patient) {
        String hasPassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(hasPassword);
        return patientRepository.save(patient);
    }

    public User registerUser(User user) {
        if (this.userRepository.findByEmail(user.getEmail()) != null)
            throw new RuntimeException("Email já cadastrado.");
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }
}
