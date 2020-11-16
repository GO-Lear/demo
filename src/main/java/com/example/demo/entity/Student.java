package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = "test")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "user_id")
    private User user;

    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}

    public String getId(){return id;}
    public void setId(String id){this.id=id;}
}
