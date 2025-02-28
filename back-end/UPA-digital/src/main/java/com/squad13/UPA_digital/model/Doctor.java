package com.squad13.UPA_digital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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

    @ManyToMany
    @JoinTable(name = "doctor-healthPost",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "healthPost_id")
    )
    private List<Health_Post> health_postList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

//    @ManyToOne
//    @JoinColumn(name = "id_prescription") // Foreign key to Prescription
//    private Prescription prescription;
//

    @Override
    public String toString() {
        return "Doctor{" +
                "crm='" + crm + '\'' +
                ", status=" + status +
                ", speciality='" + speciality + '\'' +
                ", medicalRecordList=" + medicalRecordList +
                ", calendar=" + calendar +
                ", health_postList=" + health_postList +
                '}';
    }
}