package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.TeacherDto;
import com.unibuc.fmi.schoolmanagement.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public Teacher mapToTeacherFromTeacherDto(TeacherDto teacherDto){
        return Teacher.builder()
                .id(teacherDto.getId())
                .yearsOfExperience(teacherDto.getYearsOfExperience())
                .lastName(teacherDto.getLastName())
                .firstName(teacherDto.getFirstName())
                .numberOfOlympics(teacherDto.getNumberOfOlympics())
                .build();
    }

    public TeacherDto mapToTeacherDtoFromTeacher(Teacher teacher){
        return TeacherDto.builder()
                .id(teacher.getId())
                .yearsOfExperience(teacher.getYearsOfExperience())
                .lastName(teacher.getLastName())
                .firstName(teacher.getLastName())
                .numberOfOlympics(teacher.getNumberOfOlympics())
                .build();
    }
}
