package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.exception.MyException;

public interface CourseService {
    Course Register(Course course) throws MyException;
    Boolean CheckId(String courseId);
    void Update(Course course) throws MyException;
}
