package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String findByUserId(Integer userId) {
        Optional<Student> student = studentRepository.findByUserId(userId);
        System.out.println("Student: judging");
        if (student.isEmpty())
            return null;
        System.out.println("Student: judged");
        return student.get().getId();
    }
}
