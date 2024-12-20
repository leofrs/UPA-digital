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

@OneToMany(mappedBy = "doctor")  // mappedBy points to the "doctor" property in Medical_Record
private List<Medical_Record> medical_recordList;

@OneToMany(mappedBy = "doctor")  // mappedBy points to the "doctor" property in Calendar
    private List<Calendar> calendar;

    @ManyToOne
    @JoinColumn(name = "id_admin") // Foreign key to Admin
    private Admin admin;


}
