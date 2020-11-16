package com.example.demo.dao.impl;

import com.example.demo.dao.TakesDao;
import com.example.demo.entity.Section;
import com.example.demo.entity.Takes;
import com.example.demo.repository.TakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TakesDaoImpl implements TakesDao {
    @Autowired
    TakesRepository takesRepository;

    @Override
    public List<Section> findAllByStuId(String stuId, Integer listType) {
        List<Takes> takes =  takesRepository.findAllByStuId(stuId);
        List<Section> sections = new LinkedList<>();
        List<Section> ret = new LinkedList<>();
        for (Takes take : takes) {
            if (!take.getSection().isDeleted())
                sections.add(take.getSection());
        }
        switch (listType) {
            case 0:
                for (Section section : sections) {
                    if (section.isProcessing())
                        ret.add(section);
                }
                break;
            case 1:
                for (Section section : sections) {
                    if (!section.isProcessing())
                        ret.add(section);
                }
                break;
            case 2:
                ret = sections;
                break;
            default:
                return null;
        }
        return ret;
    }
}
