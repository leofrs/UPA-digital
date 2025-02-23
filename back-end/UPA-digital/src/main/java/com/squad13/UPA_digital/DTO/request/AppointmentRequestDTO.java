package com.squad13.UPA_digital.DTO.request;

import java.time.LocalDateTime;
import java.util.Date;

public class AppointmentRequestDTO {

    private Long doctorId;

    private Long pacientId;

    private LocalDateTime dateTime;
    private String medico;
    private String descrição;
    private Long id;
    private String especialidade;
    private String posto;
    private String contato;

    // Getters e Setters
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LocalDateTime getData() {
        return dateTime;
    }
}
