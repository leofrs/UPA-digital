package com.squad13.UPA_digital.DTO.request;

import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Calendar;
import com.squad13.UPA_digital.model.Health_Post;
import com.squad13.UPA_digital.model.Medical_Record;
import lombok.Getter;


import java.time.LocalDate;
import java.util.List;
@Getter
public class DoctorRequestDTO {

    private String name;

    private LocalDate birthDate;

    private String contact;

    private String email;

    private String password;

    private byte[] photo;

    private String crm;

    private Boolean isActive;

    private String specialty;

    private List<Medical_Record> medicalRecordList;

    private List<Calendar> calendar;

    private List<Health_Post> health_postList;

    private List<Appointment> appointmentList;

}
