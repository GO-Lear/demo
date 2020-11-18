package com.example.demo.dao.impl;

import com.example.demo.dao.TeachesDao;
import com.example.demo.entity.Section;
import com.example.demo.entity.Teaches;
import com.example.demo.repository.TeachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TeachesDaoImpl implements TeachesDao {
    @Autowired
    TeachesRepository teachesRepository;

    @Override
    public List<Section> findAllByTeaId(String teaId, Integer listType) {
        List<Teaches> teaches = teachesRepository.findAllByTearId(teaId);
        List<Section> sections = new LinkedList<>();
        List<Section> ret = new LinkedList<>();
        for (Teaches teach : teaches) {
            if (!teach.getSection().isDeleted())
                sections.add(teach.getSection());
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

    @Override
    public void insertTeach(String teaId, Integer sid) {
        teachesRepository.insertTeach(sid, teaId);
    }
}
