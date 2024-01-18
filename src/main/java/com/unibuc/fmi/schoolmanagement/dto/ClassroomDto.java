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
public class ClassroomDto {
    private int id;
    @NotNull
    private int floor;
    @NotNull
    private boolean isLaboratory;
    @Min(value = 1, message = "Too short")
    private String name;
}
