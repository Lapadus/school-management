package com.unibuc.fmi.schoolmanagement.repository;

import com.unibuc.fmi.schoolmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
