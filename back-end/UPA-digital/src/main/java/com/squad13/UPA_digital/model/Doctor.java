package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Doctor extends User {

    @Column(unique = true)
    private String crm;

    private String speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Medical_Record> medical_recordList;

    @OneToMany(mappedBy = "doctor")
    private List<Calendar> calendar;
}
