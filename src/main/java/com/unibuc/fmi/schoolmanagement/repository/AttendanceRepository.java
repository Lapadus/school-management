package com.unibuc.fmi.schoolmanagement.repository;

import com.unibuc.fmi.schoolmanagement.model.Attendance;
import com.unibuc.fmi.schoolmanagement.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    @Query(value = "SELECT g FROM Attendance g WHERE g.student.id = :studentId AND g.subject.id = :subjectId")
    Optional<List<Attendance>> getAttendancesByStudentIdAndSubjectId(int studentId, int subjectId);
}
