package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findByCourseId(String courseId);

    @Transactional
    @Modifying
    @Query(value = "insert into course(title, courseid, textbook, description, avatar) values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertCourse(String title, String cid, String textbook, String description, String avatar);

    @Transactional
    @Modifying
    @Query(value = "update course set title = ?2, textbook = ?3, description = ?4, avatar = ?5 where courseid = ?1", nativeQuery = true)
    void updateCourse(String cid, String title, String textbook, String description, String avatar);
}
