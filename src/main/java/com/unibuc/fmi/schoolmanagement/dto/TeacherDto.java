package com.unibuc.fmi.schoolmanagement.dto;

import com.unibuc.fmi.schoolmanagement.enums.EProfile;
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
    private String firstName;
    private String lastName;
    private int numberOfOlympics;
}
