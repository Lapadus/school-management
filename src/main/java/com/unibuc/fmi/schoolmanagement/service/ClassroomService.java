package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.ClassroomDto;
import com.unibuc.fmi.schoolmanagement.mapper.ClassroomMapper;
import com.unibuc.fmi.schoolmanagement.model.Classroom;
import com.unibuc.fmi.schoolmanagement.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository, ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
        this.classroomMapper = classroomMapper;
    }

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    public int addClassroom(ClassroomDto classroomDto){
        Classroom classroom = classroomMapper.mapClassroomDtoToClassroom(classroomDto);
        return classroomRepository.save(classroom).getId();
    }
}
