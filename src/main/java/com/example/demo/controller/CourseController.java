package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.ResultBean;
import com.example.demo.exception.MyException;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    private Course MapToCourse (Map<String, String> map) {
        Course course = new Course();
        course.setAvatar(map.get("avatar"));
        course.setTitle(map.get("title"));
        course.setCourseId(map.get("cid"));
        course.setDescription(map.get("intro"));
        course.setTextbook(map.get("textbook"));
        return course;
    }

    @RequestMapping("/register")
    public ResultBean<Course> Register(@RequestBody Map<String, String> map) throws MyException{
        Course course = MapToCourse(map);
        System.out.println("Course: registering");
        return ResultBean.success(courseService.Register(course));
    }

    @RequestMapping("/checkcid")
    public ResultBean<Boolean> CheckId(@RequestBody Map<String, String> map) {
        String courseId = map.get("cid");
        return ResultBean.success(courseService.CheckId(courseId));
    }

    @RequestMapping("/update")
    public ResultBean<Void> Update(@RequestBody Map<String, String> map) throws MyException {
        Course course = MapToCourse(map);
        System.out.println("Course: updating");
        courseService.Update(course);
        return ResultBean.success(null);
    }
}
