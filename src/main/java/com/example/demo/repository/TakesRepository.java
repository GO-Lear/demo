package com.example.demo.repository;

import com.example.demo.entity.Takes;
import com.example.demo.entity.TakesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TakesRepository extends JpaRepository<Takes, TakesPK> {
    @Query(value = "select t from Takes t where t.student.id=:stuId")
    List<Takes> findAllByStuId(String stuId);
}
