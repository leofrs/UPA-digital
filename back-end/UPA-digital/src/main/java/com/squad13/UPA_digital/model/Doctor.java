package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataNas;
    private String contato;

    @Column(unique = true)
    private String crm;

    private String senha;
    private String especialidade;
    private byte[] foto;

    @OneToMany(mappedBy = "medico")
    private List<Medical_Record> medical_recordList;

    @OneToMany(mappedBy = "medico")
    private List<Calendar> calendar;
}
