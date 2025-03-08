package com.squad13.UPA_digital.DTO.request;

import java.time.LocalDate;

public class PatientRequestDTO {

    private String name;

    private LocalDate birthDate;

    private String contact;

    private String email;

    private String password;

    private byte[] photo;

    private String cartSusNum;

    private String address;


    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getCartSusNum() {
        return cartSusNum;
    }

    public String getAddress() {
        return address;
    }


}
