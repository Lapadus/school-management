package com.unibuc.fmi.schoolmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unibuc.fmi.schoolmanagement.model.composedIds.TeacherClassroomId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="teachers_classrooms")
public class TeacherClassrooms {
    @EmbeddedId
    private TeacherClassroomId id;

    @MapsId("classroomId")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom classroom;

    @MapsId("teacherId")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
}
