package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.SubjectDto;
import com.unibuc.fmi.schoolmanagement.model.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {
    public Subject mapToSubjectFromSubjectDto(SubjectDto subjectDto){
        return Subject.builder()
                .hoursPerWeek(subjectDto.getHoursPerWeek())
                .id(subjectDto.getId())
                .isMandatory(subjectDto.isMandatory())
                .name(subjectDto.getName())
                .build();
    }
}
