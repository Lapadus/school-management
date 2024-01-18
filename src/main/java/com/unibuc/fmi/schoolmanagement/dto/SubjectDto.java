package com.unibuc.fmi.schoolmanagement.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private int id;
    private int hoursPerWeek;
    @Min(value = 3, message = "Too short")
    private String name;
    private boolean isMandatory;
}
