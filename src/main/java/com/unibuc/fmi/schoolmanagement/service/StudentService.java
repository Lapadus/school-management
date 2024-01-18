package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.StudentDto;
import com.unibuc.fmi.schoolmanagement.dto.TeacherDto;
import com.unibuc.fmi.schoolmanagement.mapper.StudentMapper;
import com.unibuc.fmi.schoolmanagement.mapper.TeacherMapper;
import com.unibuc.fmi.schoolmanagement.model.Classroom;
import com.unibuc.fmi.schoolmanagement.model.Student;
import com.unibuc.fmi.schoolmanagement.model.Teacher;
import com.unibuc.fmi.schoolmanagement.model.TeacherClassroom;
import com.unibuc.fmi.schoolmanagement.repository.ClassroomRepository;
import com.unibuc.fmi.schoolmanagement.repository.StudentRepository;
import com.unibuc.fmi.schoolmanagement.repository.TeacherClassroomRepository;
import com.unibuc.fmi.schoolmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ClassroomRepository classroomRepository;
    private final TeacherClassroomRepository teacherClassroomRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, ClassroomRepository classroomRepository, TeacherClassroomRepository teacherClassroomRepository, TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.classroomRepository = classroomRepository;
        this.teacherClassroomRepository = teacherClassroomRepository;
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<TeacherDto> seeMyTeachers(int studentId) {
        int classroomId = studentRepository.findById((studentId)).get().getClassroom().getId();
        List<TeacherClassroom> teacherClassrooms = teacherClassroomRepository.getTeacherIdByClassroomId(classroomId).get();
        List<TeacherDto> teacherDtos = new ArrayList<>();
        TeacherDto teacherDto = null;
        for(TeacherClassroom teacherClassroom: teacherClassrooms) {
            Teacher teacher = teacherRepository.findById(teacherClassroom.getId().getTeacherId()).get();
            teacherDto = teacherMapper.mapToTeacherDtoFromTeacher(teacher);
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }

     public Student addStudent(StudentDto studentDto) {
        Student student = studentMapper.mapToStudentFromStudentDto(studentDto);
        return studentRepository.save(student);
     }

     public int moveStudent(int studentId, int moveToClassroomId) {
        Student studentToMove = studentRepository.findById(studentId).get();
        Classroom classroomToMove = classroomRepository.findById(moveToClassroomId).get();
        studentToMove.setClassroom(classroomToMove);
        return studentRepository.save(studentToMove).getId();
     }
}