package com.unibuc.fmi.schoolmanagement.dto;

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
    private int studentId;
    private int grade;
    private int subjectId;
}
