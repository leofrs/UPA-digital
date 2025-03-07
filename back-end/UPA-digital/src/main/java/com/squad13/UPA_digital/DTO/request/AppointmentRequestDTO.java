package com.squad13.UPA_digital.DTO.request;

import java.time.LocalDateTime;

public class AppointmentRequestDTO {

    private Long doctorId;
    private Long pacientId;
    private LocalDateTime dateTime;
    private String description;

    //Getters

    public Long getDoctorId() {return doctorId;}

    public Long getPacientId() {return pacientId;}

    public LocalDateTime getDateTime() {return dateTime;}

    public String getDescription() {
        return description;
    }
}
