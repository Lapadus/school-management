package com.unibuc.fmi.schoolmanagement.model.composedIds;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TeacherClassroomId implements Serializable {
    private int classroomId;
    private int teacherId;
}
