package com.unibuc.fmi.schoolmanagement.repository;

import com.unibuc.fmi.schoolmanagement.model.TeacherClassroom;
import com.unibuc.fmi.schoolmanagement.model.composedIds.TeacherClassroomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherClassroomRepository extends JpaRepository<TeacherClassroom, TeacherClassroomId> {
    @Query(value = "SELECT t FROM TeacherClassroom t WHERE t.id.classroomId = :classroomId ")
    Optional<List<TeacherClassroom>> getTeacherIdByClassroomId(int classroomId);
}
