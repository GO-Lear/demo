package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "teaches")
@IdClass(TeachesPK.class)
public class Teaches {
    private Section section;
    private Teacher teacher;

    public Teaches() {}

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherID")
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

}
