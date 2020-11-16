package com.example.demo.dao;

import com.example.demo.entity.Course;

public interface CourseDao {
    void insertCourse(Course course);
    Course findByCourseId(String courseId);
    void updateCourse(Course course);
}
