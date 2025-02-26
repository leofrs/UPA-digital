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

    private Date hours;
    private Date dates;

    @ManyToOne
    @JoinColumn(name = "id_medico")  // Foreign key for Doctor
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_paciente")  // Foreign key for Pacient
    private Patient paciente;

    @ManyToOne
    @JoinColumn(name = "id_recepcionista")
    private Receptionist recepcionista;

    @ManyToOne
    @JoinColumn(name = "id_admin") // Foreign key to Admin
    private Admin admin;


}
