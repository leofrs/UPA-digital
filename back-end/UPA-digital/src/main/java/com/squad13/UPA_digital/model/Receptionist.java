package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Receptionist extends User{

    @OneToMany(mappedBy = "recepcionista")
    private List<Calendar> calendar;
    
}
