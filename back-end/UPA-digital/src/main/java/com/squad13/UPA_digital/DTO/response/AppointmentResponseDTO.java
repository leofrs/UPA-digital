package com.squad13.UPA_digital.DTO.response;

import java.time.LocalDateTime;

public class AppointmentResponseDTO {
    private Long id;
    private Long doctorId;
    private Long pacientId;
    private LocalDateTime dateTime;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setPacientId(Long pacientId) {
        this.pacientId = pacientId;
    }

    public Long getPacientId() {
        return pacientId;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
