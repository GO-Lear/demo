package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section{
    private int id;

    private int number;
    private String endTime;
    private String semester;
    private boolean deleted;
    private boolean processing;

    private Course course;

    public Section() {}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    @Column(name = "endtime")
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public boolean isProcessing() { return processing; }
    public void setProcessing(boolean processing) { this.processing = processing; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseid")
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
