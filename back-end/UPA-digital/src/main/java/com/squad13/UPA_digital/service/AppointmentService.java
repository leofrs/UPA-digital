package com.squad13.UPA_digital.service;

import com.squad13.UPA_digital.DTO.request.AppointmentRequestDTO;
import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.repository.AppointmentRepository;
import com.squad13.UPA_digital.repository.Doctor_Repository;
import com.squad13.UPA_digital.repository.Patient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private Doctor_Repository doctorRepository;

    @Autowired
    private Patient_Repository patientRepository;

    public Appointment marcarConsulta(AppointmentRequestDTO appointmentRequestDTO) {
        //TODO: Trocar o recebimento de DTO para entidade Appointment já que DTO foi convertido na controller

        // essa função deve buscar os dados do médico no banco de dados,
        //TODO: mudar de findByName para findById
        //TODO: esse cast (Doctor) deve sair quando usarmos o conversor de DTO para entidade, também mudar a exception para EntityNotFoundException que soa melhor com a ocasião
        Doctor doctor = (Doctor) doctorRepository.findByName(appointmentRequestDTO.getDoctor())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado."));

        // deve buscar os dados do paciente no banco de dados,
//        Pacient pacientEntity = patientRepository.findById(pacient.getId());

        // deve buscar no banco de dados do médico se já tem consulta marcada para horário passado no atributo
        // senão lançar mensagem de horário indisponível
//        TODO: descobrir pq esse trecho funcionou da primeira vez, mas quando tentamos novamente deu erro Method threw 'java.lang.StackOverflowError' exception. Cannot evaluate com.squad13.UPA_digital.model.Doctor.toString()
//        TODO: esse erro Method threw 'java.lang.StackOverflowError' exception. Cannot evaluate com.squad13.UPA_digital.model.Doctor.toString() veio pq estávamos num loop infinito entre o appointment referenciando doctor que referenciava de volta o appointment usamos @JsonIgnore, mas teremos que mudar isso pra apresentar apenas o ID do doctor
//        TODO: na real eu meio que sei que é pq estávamos buscando um getData() mas nem tínhamos setData(), espero que com os atributos corretos agora funcione.
//        boolean isDoctorAvailable = appointmentRepository.existsByDoctorAndDate(Optional.ofNullable(doctor), doctorRequestDTO.getData());
//        if (isDoctorAvailable) {
//            throw new IllegalStateException("Horário indisponível para o médico.");
//        }

        // se médico estiver livre, salvar a consulta com data e hora, médico e descrição no banco de dados
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setDate(appointmentRequestDTO.getDateTime());
        appointment.setDescription(appointmentRequestDTO.getDescription());
        return appointmentRepository.save(appointment);
    }
}
