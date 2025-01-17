package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pacient extends User{
public class Pacient extends User{

    @Column(unique = true)
    private String cartSusNum;
    private String address;

    @OneToMany(mappedBy = "paciente")
    private List<Medical_Record> medical_recordList;

    @OneToMany(mappedBy = "paciente")  // mappedBy points to the "paciente" property in Calendar
    private List<Calendar> calendar;

    @ManyToOne
    @JoinColumn(name = "id_admin")  // A coluna que armazena a referência para o Admin
    private Admin admin;



    @ManyToOne
    @JoinColumn(name = "id_admin")  // A coluna que armazena a referência para o Admin
    private Admin admin;


}

