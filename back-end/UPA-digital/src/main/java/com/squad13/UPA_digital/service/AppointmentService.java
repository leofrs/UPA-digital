package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.DTO.request.AppointmentRequestDTO;
import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Pacient;
import com.squad13.UPA_digital.repository.AppointmentRepository;
import com.squad13.UPA_digital.repository.Doctor_Repository;
import com.squad13.UPA_digital.repository.Pacient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private Doctor_Repository doctorRepository;

    @Autowired
    private Pacient_Repository pacientRepository;

    public Appointment marcarConsulta(AppointmentRequestDTO doctorRequestDTO) {
        //TODO: puxar os atributos pela DTO AppointmentRequestDTO

        // essa função deve buscar os dados do médico no banco de dados,
        Doctor doctor = (Doctor) doctorRepository.findByName(doctorRequestDTO.getMedico())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado."));

        // deve buscar os dados do paciente no banco de dados,
//        Pacient pacientEntity = pacientRepository.findById(pacient.getId());

        // deve buscar no banco de dados do médico se já tem consulta marcada para horário passado no atributo
        // senão lançar mensagem de horário indisponível
        boolean isDoctorAvailable = appointmentRepository.existsByDoctorAndDate(Optional.ofNullable(doctor), doctorRequestDTO.getData());
        if (isDoctorAvailable) {
            throw new IllegalStateException("Horário indisponível para o médico.");
        }

        // se médico estiver livre, salvar a consulta com data e hora, médico e descrição no banco de dados
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setDate(doctorRequestDTO.getData());
        appointment.setDescription(doctorRequestDTO.getDescrição());
        return appointmentRepository.save(appointment);
    }
}
