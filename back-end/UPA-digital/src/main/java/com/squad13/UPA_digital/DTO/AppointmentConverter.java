package com.squad13.UPA_digital.DTO;

import com.squad13.UPA_digital.DTO.request.AppointmentRequestDTO;
import com.squad13.UPA_digital.DTO.response.AppointmentResponseDTO;
import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConverter {
    public Appointment toEntity(AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = new Appointment();

        Doctor doctor = new Doctor();
        doctor.setId(appointmentRequestDTO.getDoctorId());
        appointment.setDoctor(doctor);

        Patient patient = new Patient();
        patient.setId(appointmentRequestDTO.getPacientId());
        appointment.setPatient(patient);

        appointment.setDate(appointmentRequestDTO.getDateTime());
        appointment.setDescription(appointmentRequestDTO.getDescription());

        return appointment;
    }

    public AppointmentResponseDTO toDTO(Appointment appointment){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setId(appointment.getId());
        appointmentResponseDTO.setDoctorId(appointment.getDoctor().getId());
        appointmentResponseDTO.setPacientId(appointment.getPatient().getId());
        appointmentResponseDTO.setDescription(appointment.getDescription());

        return appointmentResponseDTO;
    }
}
