package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date horarios;
    private Date datas;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "id_recepcionista")
    private Receptionist receptionist;
}
