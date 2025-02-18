package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.request.AppointmentRequestDTO;
import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/make-appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> marcarConsulta(@RequestBody AppointmentRequestDTO requestDTO) {
        Appointment appointment = appointmentService.marcarConsulta(requestDTO);
        return ResponseEntity.ok(appointment);
    }
}
