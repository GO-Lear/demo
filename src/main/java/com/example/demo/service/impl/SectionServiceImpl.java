package com.example.demo.service.impl;

import com.example.demo.dao.*;
import com.example.demo.dto.SectionItem;
import com.example.demo.entity.Course;
import com.example.demo.entity.Section;
import com.example.demo.exception.MyException;
import com.example.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    SectionDao sectionDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    TakesDao takesDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    TeachesDao teachesDao;

    @Autowired
    TeacherDao teacherDao;

    @Override
    public Section info(Integer sid) throws MyException {
        Section section = sectionDao.findById(sid);
        if (section == null || section.isDeleted())
            throw new MyException(4, "Section dont exist");
        return section;
    }

    @Override
    public void Add(String courseId, String semester, String endTime, String teaId) throws MyException{
        if (courseDao.findByCourseId(courseId) == null)
            throw new MyException(4, "Course dont exist");
        Integer sid = sectionDao.insertSection(courseId, semester, endTime);
        teachesDao.insertTeach(teaId, sid);
    }

    @Override
    public void Delete(Integer sid) throws MyException {
        if (sectionDao.findById(sid) == null)
            throw new MyException(4, "Section dont exist");
        sectionDao.delSection(sid);
    }

    @Override
    public List<SectionItem> List(Integer userId, Integer role, Integer listType) throws MyException {
        List<SectionItem> ret = new LinkedList<>();
        if (role == 0) {
            String stuId = studentDao.findByUserId(userId);
            if (stuId == null)
                throw new MyException(4, "Student dont exist");
            List<Section> sections = takesDao.findAllByStuId(stuId, listType);
            if (sections == null)
                throw new MyException(13, "Invalid listType");
            for (Section section : sections)
                ret.add(new SectionItem(section));
        } else if (role == 1) {
            String teaId = teacherDao.findByUserId(userId);
            if (teaId == null)
                throw new MyException(4, "Teacher dont exist");
            List<Section> sections = teachesDao.findAllByTeaId(teaId, listType);
            if (sections == null)
                throw new MyException(13, "Invalid listType");
            for (Section section : sections)
                ret.add(new SectionItem(section));
        } else throw new MyException(13, "Invalid role");
        return ret;
    }
}
