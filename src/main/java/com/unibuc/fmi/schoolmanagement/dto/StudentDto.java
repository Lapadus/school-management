package com.unibuc.fmi.schoolmanagement.dto;

import com.unibuc.fmi.schoolmanagement.enums.EProfile;
import jakarta.validation.constraints.Email;
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
public class StudentDto {
    private int id;
    @Min(value = 8, message = "Age is too low")
    private int age;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Email(message = "Email invalid")
    private String email;
    private EProfile profile;

    public StudentDto(String lastName, String firstName, String email, EProfile profile, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.profile = profile;
        this.age = age;
    }
}
