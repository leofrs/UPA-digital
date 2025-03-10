package com.squad13.UPA_digital.DTO;

import com.squad13.UPA_digital.DTO.request.DoctorRequestDTO;
import com.squad13.UPA_digital.DTO.request.PatientRequestDTO;
import com.squad13.UPA_digital.DTO.request.RegisterRequestDTO;
import com.squad13.UPA_digital.DTO.response.DoctorResponseDTO;
import com.squad13.UPA_digital.DTO.response.PatientResponseDTO;
import com.squad13.UPA_digital.DTO.response.RegisterResponseDTO;
import com.squad13.UPA_digital.model.Doctor;
import com.squad13.UPA_digital.model.Patient;
import com.squad13.UPA_digital.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {
    public Doctor toDoctorEntity (DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDTO.getName());
        doctor.setBirthDate(doctorRequestDTO.getBirthDate());
        doctor.setContact(doctorRequestDTO.getContact());
        doctor.setEmail(doctorRequestDTO.getEmail());
        doctor.setPassword(doctorRequestDTO.getPassword());
        doctor.setPhoto(doctorRequestDTO.getPhoto());
        doctor.setCrm(doctorRequestDTO.getCrm());
        doctor.setIsActive(doctorRequestDTO.getIsActive() != null ? doctorRequestDTO.getIsActive() : true);
        doctor.setSpecialty(doctorRequestDTO.getSpecialty());
        return doctor;
    }

    public DoctorResponseDTO toDoctorDTO (Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setEmail(doctor.getEmail());
        doctorResponseDTO.setCrm(doctor.getCrm());
        doctorResponseDTO.setSpecialty(doctor.getSpecialty());
        doctorResponseDTO.setIsActive(doctor.getIsActive());
        return doctorResponseDTO;
    }

    public Patient toPatientEntity(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setBirthDate(patientRequestDTO.getBirthDate());
        patient.setContact(patientRequestDTO.getContact());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setCartSusNum(patientRequestDTO.getCartSusNum());
        patient.setAddress(patientRequestDTO.getAddress());
        return patient;
    }

    public PatientResponseDTO toPatientDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setBirthDate(patient.getBirthDate());
        patient.setContact(patient.getContact());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setCartSusNum(patient.getCartSusNum());
        patientResponseDTO.setAddress(patient.getAddress());
        return patientResponseDTO;
    }

    public User toRegisterEntity (RegisterRequestDTO requestDTO) {
        User user = new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        user.setRole(requestDTO.getRole());
        return user;
    }

    public RegisterResponseDTO toRegisterDto(User user) {
        RegisterResponseDTO responseDTO = new RegisterResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setRole(user.getRole());
        return responseDTO;
    }

}
