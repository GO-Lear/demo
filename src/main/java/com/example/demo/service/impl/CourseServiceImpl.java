package com.example.demo.service.impl;

import com.example.demo.dao.CourseDao;
import com.example.demo.entity.Course;
import com.example.demo.exception.MyException;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public Course Register(Course course) throws MyException{
        Course course1 = courseDao.findByCourseId(course.getCourseId());
        if (course1 != null)
            throw new MyException(12, "CourseId already exists");
        courseDao.insertCourse(course);
        return courseDao.findByCourseId(course.getCourseId());
    }

    @Override
    public Boolean CheckId(String courseId) {
        Course course = courseDao.findByCourseId(courseId);
        return course == null;//true表示当前cid已被占用
    }

    @Override
    public void Update(Course course) throws MyException {
        if (courseDao.findByCourseId(course.getCourseId()) == null)
            throw new MyException(4, "Course dont exist");
        courseDao.updateCourse(course);
    }
}
