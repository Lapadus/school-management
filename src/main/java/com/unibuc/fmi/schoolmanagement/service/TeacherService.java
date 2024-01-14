package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.TeacherDto;
import com.unibuc.fmi.schoolmanagement.mapper.TeacherMapper;
import com.unibuc.fmi.schoolmanagement.model.Teacher;
import com.unibuc.fmi.schoolmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public int addTeacher(TeacherDto teacherDto){
        Teacher teacher = teacherMapper.mapToTeacherFromTeacherDto(teacherDto);
        return teacherRepository.save(teacher).getId();
    }

    public void deleteTeacherById(int id) {
        boolean exists = teacherRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("teacher with "+ id +" doesn't exist");
        }
        teacherRepository.deleteById(id);
    }
}
