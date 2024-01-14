package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.ClassroomDto;
import com.unibuc.fmi.schoolmanagement.model.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomMapper {
    public Classroom mapClassroomDtoToClassroom(ClassroomDto classroomDto){
        return Classroom.builder()
                .id(classroomDto.getId())
                .name(classroomDto.getName())
                .floor(classroomDto.getFloor())
                .isLaboratory(classroomDto.isLaboratory())
                .build();
    }
}
