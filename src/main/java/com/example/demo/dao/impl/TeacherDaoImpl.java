package com.example.demo.dao.impl;

import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public String findByUserId(Integer userId) {
        Optional<Teacher> teacher = teacherRepository.findByUserId(userId);
        System.out.println("Teacher: judging");
        if (teacher.isEmpty())
            return null;
        System.out.println("Teacher: judged");
        return teacher.get().getId();
    }
}
