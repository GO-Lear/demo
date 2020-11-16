package com.example.demo.repository;

import com.example.demo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Integer> {
    Optional<Section> findById(Integer sid);

    @Transactional
    @Modifying
    @Query(value = "insert into section(`number`, semester, courseid, processing, endtime, deleted) values(0, ?2, ?1, 1, ?3, 0)", nativeQuery = true)
    void insertSection(String courseId, String semester, String endTime);

    @Transactional
    @Modifying
    @Query(value = "update section set deleted = 1 where ID = ?1", nativeQuery = true)
    void delSection(Integer sid);
}
