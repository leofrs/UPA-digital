package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.AdminConverter;
import com.squad13.UPA_digital.DTO.request.DoctorRequestDTO;
import com.squad13.UPA_digital.DTO.request.PatientRequestDTO;
import com.squad13.UPA_digital.DTO.request.RegisterRequestDTO;
import com.squad13.UPA_digital.DTO.response.DoctorResponseDTO;
import com.squad13.UPA_digital.DTO.response.PatientResponseDTO;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.model.User;
import com.squad13.UPA_digital.repository.UserRepository;
import com.squad13.UPA_digital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/doctors")
    public ResponseEntity<DoctorResponseDTO> addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor =  adminConverter.toDoctorEntity(doctorRequestDTO);
        Doctor savedDoctor = adminService.addDoctor(doctor);
        DoctorResponseDTO doctorResponseDTO = adminConverter.toDoctorDTO(savedDoctor);

        return ResponseEntity.status(HttpStatus.CREATED).body(doctorResponseDTO);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResponseDTO> addPacient(@RequestBody PatientRequestDTO patientRequestDTO) {
        Patient patient = adminConverter.toPatientEntity(patientRequestDTO);
        Patient savedPacient = adminService.addPatient(patient);
        PatientResponseDTO patientResponseDTO = adminConverter.toPatientDTO(savedPacient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientResponseDTO);
    }

    @GetMapping("/allpatients")
    public ResponseEntity<List<Patient>> listAllPatients() {
        List<Patient> responsePatient = adminService.listAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(responsePatient);
    }

    @GetMapping("/alldoctors")
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        List<Doctor> responseDoctor = adminService.listAllDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(responseDoctor);
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Object> register(@RequestBody @Validated RegisterRequestDTO data){
        //TODO: ARRUMAR ISSO E MANDAR PARA A SERVICE TAMBÉM!!!!
        if (this.userRepository.findByEmail(data.getEmail()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User newUser = new User(data.getName(), data.getEmail(), encryptedPassword, data.getRole());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }


}
