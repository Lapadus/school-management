package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.TeacherDto;
import com.unibuc.fmi.schoolmanagement.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<?> getTeachers() {return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);}

    @PostMapping("/addTeacher")
    public  ResponseEntity<?> addTeacher(@Valid @RequestBody TeacherDto teacherDto) { return new ResponseEntity<>(teacherService.addTeacher(teacherDto), HttpStatus.OK);}

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){ teacherService.deleteTeacherById(id); return new ResponseEntity<>(HttpStatus.OK); }

}
