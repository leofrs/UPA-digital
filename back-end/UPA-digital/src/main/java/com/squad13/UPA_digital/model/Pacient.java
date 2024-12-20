package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pacient extends User{

    @Column(unique = true)
    private String cartSusNum;
    private String address;

    @OneToMany(mappedBy = "pacient")
    private List<Medical_Record> medical_recordList;

    @OneToMany(mappedBy = "pacient")
    private List<Calendar> calendar;
}

