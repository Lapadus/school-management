package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.ClassroomDto;
import com.unibuc.fmi.schoolmanagement.service.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RequestMapping("/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ResponseEntity<?> getClassrooms() {return new ResponseEntity<>(classroomService.getClassrooms(), HttpStatus.OK);}

    @PostMapping("/addClassroom")
    public  ResponseEntity<?> addClassroom(@Valid @RequestBody ClassroomDto classroomDto) { return new ResponseEntity<>(classroomService.addClassroom(classroomDto), HttpStatus.OK);}

}
