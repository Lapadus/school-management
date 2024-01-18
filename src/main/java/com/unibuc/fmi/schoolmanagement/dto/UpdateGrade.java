package com.unibuc.fmi.schoolmanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGrade {
    private int gradeId;
    @NotNull
    @Min(value=1, message = "Not less than 1")
    private int newGrade;
}
