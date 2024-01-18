package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.controller.StudentController;
import com.unibuc.fmi.schoolmanagement.dto.StudentDto;
import com.unibuc.fmi.schoolmanagement.mapper.StudentMapper;
import com.unibuc.fmi.schoolmanagement.model.Student;
import com.unibuc.fmi.schoolmanagement.repository.StudentRepository;
import com.unibuc.fmi.schoolmanagement.utils.StudentMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @Mock
    private StudentController studentController;

    @Test
    public void getStudentsTest() {
        Student student = StudentMocks.mockStudent();
        List<Student> studentList = List.of(student);

        when(studentRepository.findAll()).thenReturn(studentList);

        List<Student> result = studentService.getStudents();
        assertEquals(result, studentList);
    }

    @Test
    public void addStudentTest() {
        Student student = StudentMocks.mockStudent();
        StudentDto studentDto = StudentMocks.mockStudentDto();

        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.mapToStudentFromStudentDto(studentDto)).thenReturn(student);
        Student result = studentService.addStudent(studentDto);

        assertEquals(result.getFirstName(), studentDto.getFirstName());
        assertEquals(result.getAge(), studentDto.getAge());
        assertEquals(result.getEmail(), studentDto.getEmail());
        assertEquals(result.getProfile(), studentDto.getProfile());
    }
}
