package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        //TODO: Criar DTO's para Doctor e Patient!!!
        Doctor savedDoctor = adminService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }


    @PostMapping("/patients")
    public ResponseEntity<Patient> addPacient(@RequestBody Patient patient) {
        //TODO: TIRAR A ENTIDADE E PASSAR O DTO!!!!!!
        //todo: SE TENTAR PASSAR ENTIDADE DE NOVO PASSAR ID COMO NULL, SENÃO DÁ ERRO
        Patient savedPacient = adminService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPacient);
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
