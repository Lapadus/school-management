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
public class AddGradeDto {
    private int id;
    @NotNull
    private int studentId;
    @NotNull
    private int grade;
    @NotNull
    private int subjectId;
}
