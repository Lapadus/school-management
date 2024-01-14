package com.unibuc.fmi.schoolmanagement.repository;

import com.unibuc.fmi.schoolmanagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
