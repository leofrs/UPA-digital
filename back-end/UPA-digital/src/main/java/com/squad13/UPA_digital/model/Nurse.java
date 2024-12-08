package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataNas;
    private String contato;
    private String senha;
    private String especialidade;

    @Column(unique = true)
    private String corem;

    private byte[] foto;
}
