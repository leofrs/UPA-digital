package com.squad13.UPA_digital.controller;

import com.squad13.UPA_digital.DTO.AppointmentConverter;
import com.squad13.UPA_digital.DTO.request.AppointmentRequestDTO;
import com.squad13.UPA_digital.DTO.response.AppointmentResponseDTO;
import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentConverter appointmentConverter;


    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> marcarConsulta(@RequestBody AppointmentRequestDTO requestDTO) {
        Appointment appointment = appointmentConverter.toEntity(requestDTO);
        Appointment confirmedAppointment = appointmentService.marcarConsulta(appointment);
        AppointmentResponseDTO responseDTO = appointmentConverter.toDTO(appointment);
        return ResponseEntity.ok(responseDTO);
    }

}
