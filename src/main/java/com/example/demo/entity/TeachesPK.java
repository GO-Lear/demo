package com.example.demo.entity;

import java.io.Serializable;

public class TeachesPK implements Serializable {
    private int section;
    private String teacher;

    public TeachesPK() {}

    public int getSection() { return section; }
    public void setSection(int section) { this.section = section; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
}
