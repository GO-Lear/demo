package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "test")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private int avatar;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public int getAvatar(){return avatar;}
    public void setAvatar(int avatar){this.avatar=avatar;}
}
