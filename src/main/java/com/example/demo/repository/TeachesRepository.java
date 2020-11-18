package com.example.demo.repository;

import com.example.demo.entity.Teaches;
import com.example.demo.entity.TeachesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeachesRepository extends JpaRepository<Teaches, TeachesPK> {
    @Query(value = "select t from Teaches t where t.teacher.id=:teaId")
    List<Teaches> findAllByTearId(String teaId);

    @Transactional
    @Modifying
    @Query(value = "insert into teaches(ID, teacherID) values(?1, ?2)", nativeQuery = true)
    void insertTeach(Integer sid, String teaId);
}
