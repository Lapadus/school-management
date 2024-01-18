package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.MoveStudentDto;
import com.unibuc.fmi.schoolmanagement.dto.StudentDto;
import com.unibuc.fmi.schoolmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getStudents() {return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);}

    @GetMapping("/seeMyTeachers/{studentId}")
    public ResponseEntity<?> seeMyTeachers(@PathVariable int studentId) {return new ResponseEntity<>(studentService.seeMyTeachers(studentId), HttpStatus.OK);}

    @PostMapping("/addStudent")
    public  ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto studentDto) { return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);}

    @PutMapping("/moveStudent")
    public  ResponseEntity<?> moveStudent(@Valid @RequestBody MoveStudentDto moveStudentDto) { return new ResponseEntity<>(studentService.moveStudent(moveStudentDto.getStudentId(), moveStudentDto.getMoveToClassroomId()), HttpStatus.OK);}

}
