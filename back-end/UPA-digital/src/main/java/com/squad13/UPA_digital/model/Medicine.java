package com.squad13.UPA_digital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Pacient paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "id_admin")  // Relacionamento com Admin (muitos para um)
    private Admin admin;
}
