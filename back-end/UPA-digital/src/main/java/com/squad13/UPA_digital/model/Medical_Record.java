package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Medical_Record {
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
