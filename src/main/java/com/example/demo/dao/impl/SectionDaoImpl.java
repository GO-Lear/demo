package com.example.demo.dao.impl;

import com.example.demo.dao.SectionDao;
import com.example.demo.entity.Course;
import com.example.demo.entity.Section;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SectionDaoImpl implements SectionDao {
    @Autowired
    SectionRepository sectionRepository;

    @Override
    public Section findById(Integer sid) {
        Optional<Section> sections = sectionRepository.findById(sid);
        System.out.println("Section: judging");
        if (sections.isEmpty())
            return null;
        System.out.println("Section: judged");
        return sections.get();
    }

    @Override
    public void insertSection(String courseId, String semester, String endTime) {
        sectionRepository.insertSection(courseId, semester, endTime);
    }

    @Override
    public void delSection(Integer sid) {
        sectionRepository.delSection(sid);
    }
}
