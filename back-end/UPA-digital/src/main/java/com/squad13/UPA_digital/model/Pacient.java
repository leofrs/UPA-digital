package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataNas;
    private String endereco;
    private String contato;

    @Column(unique = true)
    private String cartSusNum;

    private String senha;
    private byte[] foto;

    @OneToMany(mappedBy = "paciente")
    private List<Medical_Record> prontuarios;

    @OneToMany(mappedBy = "paciente")
    private List<Calendar> calendar;
}

