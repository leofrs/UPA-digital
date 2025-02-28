package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.repository.DoctorRepository;
import com.squad13.UPA_digital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }
}
