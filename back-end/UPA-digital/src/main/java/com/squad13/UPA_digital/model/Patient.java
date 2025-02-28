package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends User{

    @Column(unique = true, nullable = false)
    private String cartSusNum;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "paciente")
    private List<Medical_Record> medical_recordList;

    @OneToMany(mappedBy = "paciente")  // mappedBy points to the "paciente" property in Calendar
    private List<Calendar> calendar;

}

