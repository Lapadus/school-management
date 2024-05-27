package com.unibuc.fmi.schoolmanagement.dto;

import com.unibuc.fmi.schoolmanagement.enums.EProfile;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    private int id;
    private int yearsOfExperience;
    @NotNull(message = "Can not be null")
    private String firstName;
    @NotNull(message = "Can not be null")
    private String lastName;
    private int subjectId;
    private int numberOfOlympics;
}
