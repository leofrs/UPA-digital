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
}
