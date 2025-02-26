package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.request.AppointmentRequestDTO;
import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.service.AppointmentService;
import com.squad13.UPA_digital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/home/make-appointment")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Appointment> marcarConsulta(@RequestBody AppointmentRequestDTO requestDTO) {
//        TODO: trocar essa função para converter o DTO para entidade Appointment e no retorno converter de volta para responseDTO
        Appointment appointment = appointmentService.marcarConsulta(requestDTO);
        return ResponseEntity.ok(appointment);
    }
    @GetMapping
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        List<Doctor> responseDoctor = doctorService.listAllDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(responseDoctor);
    }

}
