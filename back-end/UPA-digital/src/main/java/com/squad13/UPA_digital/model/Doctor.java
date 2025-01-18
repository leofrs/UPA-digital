package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Doctor extends User {

    @Column(unique = true, nullable = false)
    private String crm;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String speciality;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medical_Record> medicalRecordList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calendar> calendar;

    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false) // Foreign key to Admin
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "id_pacient", nullable = false) // Foreign key to Pacient
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "id_prescription", nullable = false) // Foreign key to Prescription
    private Prescription prescription;
    
}