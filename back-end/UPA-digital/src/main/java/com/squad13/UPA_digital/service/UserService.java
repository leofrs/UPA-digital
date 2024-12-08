package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Nurse;
import com.squad13.UPA_digital.model.Pacient;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.Doctor_Repository;
import com.squad13.UPA_digital.repository.NurseRepository;
import com.squad13.UPA_digital.repository.Pacient_Repository;
import com.squad13.UPA_digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// @Service para o springboot reconhecer que essa classe é uma service do projeto
@Service
public class UserService {

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private Doctor_Repository doctorRepository;

    @Autowired
    private Pacient_Repository pacientRepository;

    public Optional<User> login(String identifier, String password) throws Exception{
        Optional<Pacient> patient = pacientRepository.findByCartSusNumAndPassword(identifier, password);
        if (patient.isPresent()) {
            //TODO: arrumar melhor esses Optional.of
            return Optional.of(patient.get());
        }
        Optional<Doctor> doctor = doctorRepository.findByCrmAndPassword(identifier, password);
        if (doctor.isPresent()) {
            return Optional.of(doctor.get());
        }
        Optional<Nurse> nurse = nurseRepository.findByCoremAndPassword(identifier, password);
        if (nurse.isPresent()) {
            return Optional.of(nurse.get());
        }
        throw new Exception("login inválido");
    }
}
