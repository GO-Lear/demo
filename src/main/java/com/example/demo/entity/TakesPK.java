package com.example.demo.entity;

import java.io.Serializable;

public class TakesPK implements Serializable {
    private int section;
    private String student;

    public TakesPK() {}

    public int getSection() { return section; }
    public void setSection(int section) { this.section = section; }

    public String getStudent() { return student; }
    public void setStudent(String student) { this.student = student; }
}
