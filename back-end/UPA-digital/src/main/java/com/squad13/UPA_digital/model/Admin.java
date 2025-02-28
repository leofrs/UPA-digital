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
public class Admin extends User {


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
