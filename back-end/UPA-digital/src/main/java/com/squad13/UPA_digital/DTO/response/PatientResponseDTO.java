package com.squad13.UPA_digital.DTO.response;

import com.squad13.UPA_digital.model.Calendar;
import com.squad13.UPA_digital.model.Medical_Record;

import java.time.LocalDate;
import java.util.List;

public class PatientResponseDTO {

    private String name;

    private LocalDate birthDate;

    private String contact;

    private String email;

    private Integer version;

    private String cartSusNum;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCartSusNum() {
        return cartSusNum;
    }

    public void setCartSusNum(String cartSusNum) {
        this.cartSusNum = cartSusNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
