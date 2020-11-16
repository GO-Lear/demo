package com.example.demo.dao.impl;

import com.example.demo.dao.CourseDao;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void insertCourse(Course course) {
        courseRepository.insertCourse(course.getTitle(), course.getCourseId(), course.getTextbook(), course.getDescription(), course.getAvatar());
    }

    @Override
    public Course findByCourseId(String courseId) {
        Optional<Course> courses = courseRepository.findByCourseId(courseId);
        System.out.println("Course: judging");
        if (courses.isEmpty())
            return null;
        System.out.println("Course: judged");
        return courses.get();
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.updateCourse(course.getCourseId(), course.getTitle(), course.getTextbook(), course.getDescription(), course.getAvatar());
    }
}
