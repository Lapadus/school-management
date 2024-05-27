package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.SubjectDto;
import com.unibuc.fmi.schoolmanagement.mapper.SubjectMapper;
import com.unibuc.fmi.schoolmanagement.model.Subject;
import com.unibuc.fmi.schoolmanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public List<Subject> getSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjectRepository.findAll();
    }

    public int addSubject(SubjectDto subjectDto){
        Subject subject = subjectMapper.mapToSubjectFromSubjectDto(subjectDto);
        return subjectRepository.save(subject).getId();
    }

    public void deleteSubjectById(int id) {
        boolean exists = subjectRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("subject with "+ id +" doesn't exist");
        }
        subjectRepository.deleteById(id);
    }

    public int updateSubject(SubjectDto subjectDto){
        boolean exists = subjectRepository.existsById(subjectDto.getId());
        if(!exists) {
            throw new IllegalStateException("subject with " + subjectDto.getId() + " doesn't exist");
        }
        Subject newBook = subjectMapper.mapToSubjectFromSubjectDto(subjectDto);
        return subjectRepository.save(newBook).getId();
    }
}
