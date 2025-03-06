package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Lob
    private byte[] photo;
    @Version
    private Integer version;

}