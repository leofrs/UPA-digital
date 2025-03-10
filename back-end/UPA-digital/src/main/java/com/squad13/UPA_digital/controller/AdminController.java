package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.AdminConverter;
import com.squad13.UPA_digital.DTO.request.DoctorRequestDTO;
import com.squad13.UPA_digital.DTO.request.PatientRequestDTO;
import com.squad13.UPA_digital.DTO.request.RegisterRequestDTO;
import com.squad13.UPA_digital.DTO.response.DoctorResponseDTO;
import com.squad13.UPA_digital.DTO.response.PatientResponseDTO;
import com.squad13.UPA_digital.DTO.response.RegisterResponseDTO;
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
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/doctors")
    public ResponseEntity<DoctorResponseDTO> addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = adminConverter.toDoctorEntity(doctorRequestDTO);
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

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody @Validated RegisterRequestDTO registerRequestDTO) {
        //TODO: MUDAR ESSA FUNÇÃO PARA RECEBER AS OUTRAS ENTIDADES AO INVÉS DE USER
        User user = adminConverter.toRegisterEntity(registerRequestDTO);
        User savedUser = adminService.registerUser(user);
        RegisterResponseDTO registerResponseDTO = adminConverter.toRegisterDto(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponseDTO);
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


}
