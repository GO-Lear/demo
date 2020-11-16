package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query(value = "select t from Teacher t where t.user.id=:userId")
    Optional<Teacher> findByUserId(Integer userId);
}
