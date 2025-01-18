package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Receptionist extends User{

    @OneToMany(mappedBy = "recepcionista")
    private List<Calendar> calendar;
    
}
