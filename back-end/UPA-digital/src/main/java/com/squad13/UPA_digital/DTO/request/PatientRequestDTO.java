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

}
