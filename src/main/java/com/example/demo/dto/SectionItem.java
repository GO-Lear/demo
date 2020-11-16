package com.example.demo.dto;

import com.example.demo.entity.Course;
import com.example.demo.entity.Section;

public class SectionItem {
    private int id;
    private String semester;
    private boolean processing;
    private Course course;

    public SectionItem(Section section) {
        this.id = section.getId();
        this.semester = section.getSemester();
        this.processing = section.isProcessing();
        this.course = section.getCourse();
    }

    public SectionItem() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public boolean isProcessing() { return processing; }
    public void setProcessing(boolean processing) { this.processing = processing; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}

