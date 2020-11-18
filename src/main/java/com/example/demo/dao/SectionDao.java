package com.example.demo.dao;

import com.example.demo.entity.Section;

public interface SectionDao {
    Section findById(Integer sid);
    Integer insertSection(String courseId, String semester, String endTime);
    void delSection(Integer sid);
}
