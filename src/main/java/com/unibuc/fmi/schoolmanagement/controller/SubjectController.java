package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.SubjectDto;
import com.unibuc.fmi.schoolmanagement.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping
    public ResponseEntity<?> getSubjects() {return new ResponseEntity<>(subjectService.getSubjects(), HttpStatus.OK);}

    @PostMapping("/addSubject")
    public  ResponseEntity<?> addSubject(@RequestBody SubjectDto subjectDto) { return new ResponseEntity<>(subjectService.addSubject(subjectDto), HttpStatus.OK);}

    @DeleteMapping("/deleteSubject/{id}")
    public ResponseEntity<?> deleteSubjectById(@PathVariable int id){ subjectService.deleteSubjectById(id); return new ResponseEntity<>(HttpStatus.OK); }

    @PutMapping("/updateSubject")
    public  ResponseEntity<?> updateSubject(@Valid @RequestBody SubjectDto subjectDto) { return new ResponseEntity<>(subjectService.updateSubject(subjectDto), HttpStatus.OK);}

}
