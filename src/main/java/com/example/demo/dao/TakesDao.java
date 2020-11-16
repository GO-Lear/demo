package com.example.demo.dao;

import com.example.demo.entity.Section;

import java.util.List;

public interface TakesDao {
    List<Section> findAllByStuId(String stuId, Integer listType);
}
