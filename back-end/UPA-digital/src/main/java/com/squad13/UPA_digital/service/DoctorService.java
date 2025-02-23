package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.repository.Doctor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private Doctor_Repository doctorRepository;

    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }
}
