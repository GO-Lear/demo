package com.example.demo.service;

import com.example.demo.dto.SectionItem;
import com.example.demo.entity.Section;
import com.example.demo.exception.MyException;

import java.util.List;

public interface SectionService {
    Section info(Integer sid) throws MyException;
    void Add(String courseId, String semester, String endTime) throws MyException;
    void Delete(Integer sid) throws MyException;
    List<SectionItem> List(Integer userId, Integer role, Integer listType) throws MyException;
}
