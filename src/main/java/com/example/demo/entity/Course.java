package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    private String courseId;

    private String title;
    private String textbook;
    private String description;
    private String avatar;

    public Course() {}

    @Id
    @Column(name = "courseid")
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getTextbook() { return textbook; }
    public void setTextbook(String textbook) { this.textbook = textbook; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}
