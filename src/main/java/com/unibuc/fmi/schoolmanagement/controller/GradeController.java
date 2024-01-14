package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.AddGradeDto;
import com.unibuc.fmi.schoolmanagement.dto.UpdateGrade;
import com.unibuc.fmi.schoolmanagement.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/myGrade/{studentId}")
    public ResponseEntity<?> getMyGrades(@PathVariable int studentId) {return new ResponseEntity<>(gradeService.getMyGrades(studentId), HttpStatus.OK);}

    @GetMapping("/getSubjectGrade/{studentId}/{subjectId}")
    public ResponseEntity<?> getSubjectGrade(@PathVariable int studentId, @PathVariable int subjectId) {return new ResponseEntity<>(gradeService.getSubjectGrade(studentId, subjectId), HttpStatus.OK);}

    @GetMapping("/getAverageGrade/{studentId}/{subjectId}")
    public ResponseEntity<?> getAverageGrade(@PathVariable int studentId, @PathVariable int subjectId) {return new ResponseEntity<>(gradeService.getAverageGrade(studentId, subjectId), HttpStatus.OK);}

    @PostMapping("/addGrade")
    public  ResponseEntity<?> addGradeForSubject(@RequestBody AddGradeDto addGradeDto) { return new ResponseEntity<>(gradeService.addGradeForSubject(addGradeDto), HttpStatus.OK);}

    @DeleteMapping("/deleteGrade/{id}")
    public ResponseEntity<?> deleteGradeById(@PathVariable int id){ gradeService.deleteGradeById(id); return new ResponseEntity<>(HttpStatus.OK); }

    @PutMapping("/updateGrade")
    public  ResponseEntity<?> updateGrade(@RequestBody UpdateGrade updateGrade) { return new ResponseEntity<>(gradeService.modifyGrade(updateGrade.getGradeId(), updateGrade.getNewGrade()), HttpStatus.OK);}

}
