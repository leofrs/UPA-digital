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
 *   <li>{@link com.squad13.UPA_digital.repository.DoctorRepository}</li>
 *   <li>{@link com.squad13.UPA_digital.repository.PatientRepository}</li>
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

import com.squad13.UPA_digital.model.*;
import com.squad13.UPA_digital.repository.UserRepository;
import com.squad13.UPA_digital.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    public String login(String identifier, String password) throws Exception {
        User user = (User) this.userRepository.findByEmail(identifier);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return this.tokenService.generateToken(user);
        }
        return identifier;
    }
}
