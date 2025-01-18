package com.squad13.UPA_digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataNas;
    private String contato;
    
    @Column(unique = true)
    private String email;

    private String senha;
    private String cpf;
    private byte[] foto;

    @OneToMany(mappedBy = "admin")
    private List<Medical_Record> medical_recordList;

    @OneToMany(mappedBy = "admin")
    private List<Calendar> calendar;

    @OneToMany(mappedBy = "admin")
    private List<Doctor> doctorList;

    @OneToMany(mappedBy = "admin")
    private List<Pacient> pacientList;

    //#TODO: Add the following attributes to the User class
     /** 
    @OneToMany(mappedBy = "admin")
    private List<Medicine> medicineList;

    @OneToMany(mappedBy = "admin")
    private List<Exam> examList;

    @OneToMany(mappedBy = "admin")
    private List<Prescription> prescriptionList;

    @OneToMany(mappedBy = "admin")
    private List<Consultation> consultationList;

    @OneToMany(mappedBy = "admin")
    private List<Report> reportList;

    @OneToMany(mappedBy = "admin")
    private List<Notification> notificationList;

    @OneToMany(mappedBy = "admin")
    private List<Chat> chatList;

    @OneToMany(mappedBy = "admin")
    private List<Chat_Message> chat_messageList;

    @OneToMany(mappedBy = "admin")
    private List<Chat_User> chat_userList;

    @OneToMany(mappedBy = "admin")
    private List<Chat_User> chat_userList1;

    @OneToMany(mappedBy = "admin")
    private List<Chat_User> chat_userList2;

    @OneToMany(mappedBy = "admin")
    private List<Chat_User> chat_userList3;

    **/
    
}
