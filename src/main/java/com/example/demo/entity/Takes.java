package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "takes")
@IdClass(TakesPK.class)
public class Takes {
    private Section section;
    private Student student;

    public Takes() {}

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentID")
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
