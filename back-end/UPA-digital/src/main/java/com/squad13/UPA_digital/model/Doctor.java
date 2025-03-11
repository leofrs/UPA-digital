package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor extends SuperUser {

    @Column(unique = true, nullable = false)
    private String crm;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private String specialty;

    @ManyToMany
    @JoinTable(name = "doctor-healthPost",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "healthPost_id")
    )
    private List<Health_Post> health_postList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_DOCTOR"));
    }
}