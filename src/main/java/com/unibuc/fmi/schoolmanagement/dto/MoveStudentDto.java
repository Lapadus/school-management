package com.unibuc.fmi.schoolmanagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoveStudentDto {
    private int studentId;
    @NotNull
    private int moveToClassroomId;
}
