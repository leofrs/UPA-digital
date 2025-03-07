package com.squad13.UPA_digital.DTO.request;

import com.squad13.UPA_digital.model.Appointment;
import com.squad13.UPA_digital.model.Calendar;
import com.squad13.UPA_digital.model.Health_Post;
import com.squad13.UPA_digital.model.Medical_Record;



import java.time.LocalDate;
import java.util.List;
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

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getCrm() {
        return crm;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Medical_Record> getMedicalRecordList() {
        return medicalRecordList;
    }

    public List<Calendar> getCalendar() {
        return calendar;
    }

    public List<Health_Post> getHealth_postList() {
        return health_postList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }
}
