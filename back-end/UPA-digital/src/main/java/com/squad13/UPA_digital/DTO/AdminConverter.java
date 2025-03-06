package com.squad13.UPA_digital.DTO;

import com.squad13.UPA_digital.DTO.request.DoctorRequestDTO;
import com.squad13.UPA_digital.DTO.response.DoctorResponseDTO;
import com.squad13.UPA_digital.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {
    public Doctor toDoctorEntity (DoctorRequestDTO requestDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(requestDTO.getName());
        doctor.setBirthDate(requestDTO.getBirthDate());
        doctor.setContact(requestDTO.getContact());
        doctor.setEmail(requestDTO.getEmail());
        doctor.setPassword(requestDTO.getPassword());
        doctor.setPhoto(requestDTO.getPhoto());
        doctor.setCrm(requestDTO.getCrm());
        doctor.setIsActive(true);
        doctor.setSpecialty(requestDTO.getSpecialty());
        doctor.setMedicalRecordList(requestDTO.getMedicalRecordList());
        return doctor;
    }

    public DoctorResponseDTO toDoctorDTO (Doctor doctor) {
        DoctorResponseDTO responseDTO = new DoctorResponseDTO();
        responseDTO.
    }
}
