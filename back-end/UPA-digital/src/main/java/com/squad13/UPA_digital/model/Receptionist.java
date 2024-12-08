package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataNas;
    private String contato;
    private String senha;

    @OneToMany(mappedBy = "recepcionista")
    private List<Calendar> consultas;
}
