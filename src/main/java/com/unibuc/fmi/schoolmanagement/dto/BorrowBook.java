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
public class BorrowBook {
    @NotNull
    private int bookId;
    @NotNull
    private int studentId;
}
