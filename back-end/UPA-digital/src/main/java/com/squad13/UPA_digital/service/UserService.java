/**
 * UserService is a service class that provides functionality for user authentication
 * in the UPA-digital application. It handles login operations for different types of users
 * including Pacient, Doctor, and Nurse.
 *
 * <h2>Usage</h2>
 * To use this service, you need to have the following repositories autowired:
 * <ul>
 *   <li>NurseRepository</li>
 *   <li>Doctor_Repository</li>
 *   <li>Pacient_Repository</li>
 * </ul>
 *
 * <h2>Example</h2>
 * <pre>
 * {@code
 * @Autowired
 * private UserService userService;
 *
 * public void authenticateUser(String identifier, String password) {
 *     try {
 *         Optional<User> user = userService.login(identifier, password);
 *         if (user.isPresent()) {
 *             // User authenticated successfully
 *         }
 *     } catch (Exception e) {
 *         // Handle login failure
 *     }
 * }
 * }
 * </pre>
 *
 * <h2>Methods</h2>
 * <ul>
 *   <li>{@link #login(String, String)} - Authenticates a user based on identifier and password.</li>
 * </ul>
 *
 * <h2>Dependencies</h2>
 * This class depends on the following repositories:
 * <ul>
 *   <li>{@link com.squad13.UPA_digital.repository.NurseRepository}</li>
 *   <li>{@link com.squad13.UPA_digital.repository.Doctor_Repository}</li>
 *   <li>{@link com.squad13.UPA_digital.repository.Patient_Repository}</li>
 * </ul>
 *
 * <h2>Exceptions</h2>
 * <ul>
 *   <li>{@link java.lang.Exception} - Thrown when login credentials are invalid.</li>
 * </ul>
 *
 * <h2>Annotations</h2>
 * <ul>
 *   <li>{@link org.springframework.stereotype.Service} - Indicates that this class is a service component in Spring.</li>
 *   <li>{@link org.springframework.beans.factory.annotation.Autowired} - Used for automatic dependency injection.</li>
 * </ul>
 */
package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Nurse;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.Doctor_Repository;
import com.squad13.UPA_digital.repository.NurseRepository;
import com.squad13.UPA_digital.repository.Patient_Repository;
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
    private Patient_Repository pacientRepository;

    public Optional<User> login(String identifier, String password) throws Exception{
        Optional<Patient> patient = pacientRepository.findByCartSusNumAndPassword(identifier, password);
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
