package com.squad13.UPA_digital.DTO.request;

import com.squad13.UPA_digital.model.Calendar;
import com.squad13.UPA_digital.model.Medical_Record;

import java.time.LocalDate;
import java.util.List;

public class PatientRequestDTO {

    private String name;

    private LocalDate birthDate;

    private String contact;

    private String email;

    private String password;

    private byte[] photo;

    private Integer version;

    private String cartSusNum;

    private String address;

    private List<Medical_Record> medical_recordList;

    private List<Calendar> calendar;

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

    public Integer getVersion() {
        return version;
    }

    public String getCartSusNum() {
        return cartSusNum;
    }

    public String getAddress() {
        return address;
    }

    public List<Medical_Record> getMedical_recordList() {
        return medical_recordList;
    }

    public List<Calendar> getCalendar() {
        return calendar;
    }
}
