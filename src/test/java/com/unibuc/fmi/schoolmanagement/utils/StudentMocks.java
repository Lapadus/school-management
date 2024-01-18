package com.unibuc.fmi.schoolmanagement.utils;

import com.unibuc.fmi.schoolmanagement.dto.StudentDto;
import com.unibuc.fmi.schoolmanagement.enums.EProfile;
import com.unibuc.fmi.schoolmanagement.model.Student;

public class StudentMocks {

    public static Student mockStudent() {
        Student student = new Student("Lapadus", "Ion", "Raluca@gmail.com", EProfile.REAL, 5);
        return student;
    }

    public static StudentDto mockStudentDto() {
        StudentDto studentDto = new StudentDto("Lapadus", "Ion", "Raluca@gmail.com", EProfile.REAL, 5);
        return studentDto;
    }

    public static Student mockWrongStudent() {
        Student student = new Student("Lapadus", "Ion", "Raluca@gmail.com", EProfile.REAL, 5);
        return student;
    }

    public static StudentDto mockWrongStudentDto() {
        StudentDto studentDto = new StudentDto("Lapadus", "Ion", "Raluca@gmail.com", EProfile.REAL, 5);
        return studentDto;
    }
}
