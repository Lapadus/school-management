package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.AddGradeDto;
import com.unibuc.fmi.schoolmanagement.model.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeMapper {

    public Grade mapBookDtoToBook(AddGradeDto addGradeDto){
        return Grade.builder()
                .id(addGradeDto.getId())
                .grade(addGradeDto.getGrade())

                .build();
    }
    public AddGradeDto mapGradeToGradeDto(Grade grade){
        return AddGradeDto.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .build();
    }
}
