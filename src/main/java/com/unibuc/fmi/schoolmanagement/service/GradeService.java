package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.AddGradeDto;
import com.unibuc.fmi.schoolmanagement.mapper.GradeMapper;
import com.unibuc.fmi.schoolmanagement.model.*;
import com.unibuc.fmi.schoolmanagement.repository.GradeRepository;
import com.unibuc.fmi.schoolmanagement.repository.StudentRepository;
import com.unibuc.fmi.schoolmanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService{
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GradeMapper gradeMapper;

    @Autowired
    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, SubjectRepository subjectRepository, GradeMapper gradeMapper) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.gradeMapper = gradeMapper;
    }

    public List<Grade> getMyGrades(int studentId) {
        List<Grade> gradesForStudent = gradeRepository.getGradesByStudentId(studentId).get();
        return gradesForStudent;
    }

    public List<AddGradeDto> getSubjectGrade(int studentId, int subjectId) {
        List<Grade> gradesForStudent = gradeRepository.getGradesByStudentId(studentId).get();
        List<AddGradeDto> gradesDtos = new ArrayList<>();
        AddGradeDto gradeDto = null;
        for(Grade gradeForStudent: gradesForStudent) {
            if (gradeForStudent.getSubject().getId() == subjectId){
                gradeDto = gradeMapper.mapGradeToGradeDto(gradeForStudent);
                gradesDtos.add(gradeDto);
            }
        }
        return gradesDtos;
    }

    public float getAverageGrade(int studentId, int subjectId) {
        List<Grade> gradesForStudent = gradeRepository.getGradesByStudentId(studentId).get();
        List<AddGradeDto> gradesDtos = new ArrayList<>();
        AddGradeDto gradeDto = null;
        for(Grade gradeForStudent: gradesForStudent) {
            if (gradeForStudent.getSubject().getId() == subjectId) {
                gradeDto = gradeMapper.mapGradeToGradeDto(gradeForStudent);
                gradesDtos.add(gradeDto);
            }
        }
        float sum = 0; int nr = 0;
        for (AddGradeDto grade: gradesDtos) {
            sum += grade.getGrade();
            nr++;
        }
        return sum/nr;
    }

    public int addGradeForSubject(AddGradeDto addGradeDto){
        Student student = studentRepository.findById(addGradeDto.getStudentId()).get();
        Subject subject = subjectRepository.findById(addGradeDto.getSubjectId()).get();
        Grade grade = Grade.builder()
                .grade(addGradeDto.getGrade())
                .student(student)
                .subject(subject)
                .build();
        return gradeRepository.save(grade).getId();
    }

    public void deleteGradeById(int id) {
        boolean exists = gradeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("grade with "+ id +" doesn't exist");
        }
        gradeRepository.deleteById(id);
    }

    public int modifyGrade(int gradeId, int newGrade){
        Grade grade = gradeRepository.findById(gradeId).get();
        grade.setGrade(newGrade);
        return gradeRepository.save(grade).getId();
    }
}
