package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Nurse extends User {
    
    @Column(unique = true)
    private String corem;

    private String speciality;

    @ManyToOne
    @JoinColumn(name = "id_pacient")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "id_medicine")
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "id_exam")
    private Exam exam;
}
