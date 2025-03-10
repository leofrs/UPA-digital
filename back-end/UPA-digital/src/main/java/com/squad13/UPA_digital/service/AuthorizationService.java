package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.SuperUser;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.DoctorRepository;
import com.squad13.UPA_digital.repository.PatientRepository;
import com.squad13.UPA_digital.repository.ReceptionistRepository;
import com.squad13.UPA_digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AuthorizationService implements UserDetailsService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ReceptionistRepository receptionistRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<? extends SuperUser> user = doctorRepository.findByEmail(email);
        if (user.isEmpty()) {
            user = patientRepository.findByEmail(email);
        }
        if (user.isEmpty()) {
            user = receptionistRepository.findByEmail(email);
        }
        return user.orElseThrow(() -> new UsernameNotFoundException("usuário não encontrado"));
    }
}
