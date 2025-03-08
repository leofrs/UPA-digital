package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends SuperUser{

    @Column(unique = true, nullable = false)
    private String cartSusNum;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "paciente")
    private List<Medical_Record> medical_recordList;


}

