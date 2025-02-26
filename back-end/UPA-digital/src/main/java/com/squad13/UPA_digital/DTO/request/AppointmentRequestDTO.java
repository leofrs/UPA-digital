package com.squad13.UPA_digital.DTO.request;

import java.time.LocalDateTime;

public class AppointmentRequestDTO {

    private Long doctorId;

    private Long pacientId;

    private String doctor;
    private LocalDateTime dateTime;
    private String description;

    // Getters e Setters

    public Long getDoctorId() {return doctorId;}

    public void setDoctorId(Long doctorId) {this.doctorId = doctorId;}

    public Long getPacientId() {return pacientId;}

    public void setPacientId(Long pacientId) {this.pacientId = pacientId;}

    public String getDoctor() {return doctor;}

    public void setDoctor(String doctor) {this.doctor = doctor;}

    public LocalDateTime getDateTime() {return dateTime;}

    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
