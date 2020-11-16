package com.example.demo.dao;

import com.example.demo.entity.Section;

import java.util.List;

public interface TeachesDao {
    List<Section> findAllByTeaId(String teaId, Integer listType);
}
