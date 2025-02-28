package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.repository.AppointmentRepository;
import com.squad13.UPA_digital.repository.DoctorRepository;
import com.squad13.UPA_digital.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Appointment marcarConsulta(Appointment appointment) {
        // essa função deve buscar os dados do médico no banco de dados,
        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado."));

        // deve buscar os dados do paciente no banco de dados,
        Patient patient = patientRepository.findById(appointment.getPatient().getId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado."));

        // deve buscar no banco de dados do médico se já tem consulta marcada para horário passado no atributo
        LocalDateTime appointmentDate = appointment.getDate();

        boolean hasAppointmentAtSameTime = appointmentRepository.existsByDoctorAndDate(doctor, appointmentDate);
        if (hasAppointmentAtSameTime) {
            // senão lançar mensagem de horário indisponível
            throw new IllegalStateException("Médico já possui consulta agendada para este horário.");
        }
        // fazer algo para bloquear que agende 2 consultas com tempo menor de 30 minutos entre eles
        LocalDateTime startRange = appointmentDate.minusMinutes(29);
        LocalDateTime endRange = appointmentDate.plusMinutes(29);

        boolean hasConflictingAppointment = appointmentRepository.existsByDoctorAndDateBetween(doctor, startRange, endRange);
        if (hasConflictingAppointment) {
            throw new IllegalStateException("Já existe uma consulta agendada para este médico em um intervalo menor que 30 minutos.");
        }
        // se médico estiver livre, salvar a consulta com data e hora, médico e descrição no banco de dados
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        return appointmentRepository.save(appointment);
    }
}
