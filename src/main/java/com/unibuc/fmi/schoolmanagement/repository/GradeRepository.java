package com.unibuc.fmi.schoolmanagement.repository;

import com.unibuc.fmi.schoolmanagement.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Query(value = "SELECT g FROM Grade g WHERE g.student.id = :studentId ")
    Optional<List<Grade>> getGradesByStudentId(int studentId);
}
