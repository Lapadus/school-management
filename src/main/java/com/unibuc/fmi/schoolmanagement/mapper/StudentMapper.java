package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.StudentDto;
import com.unibuc.fmi.schoolmanagement.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student mapToStudentFromStudentDto(StudentDto studentDto){
        return Student.builder()
                .id(studentDto.getId())
                .firstName(studentDto.getFirstName())
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .lastName(studentDto.getLastName())
                .profile(studentDto.getProfile())
                .build();
    }
}
