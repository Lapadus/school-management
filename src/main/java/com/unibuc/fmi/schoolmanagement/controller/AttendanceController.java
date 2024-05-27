package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.AddAttendanceDto;
import com.unibuc.fmi.schoolmanagement.dto.AttendanceDto;
import com.unibuc.fmi.schoolmanagement.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RequestMapping("/attendances")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/getAttendances/{studentId}/{subjectId}")
    public ResponseEntity<?> getAttendances(@PathVariable int studentId, @PathVariable int subjectId) {return new ResponseEntity<>(attendanceService.getAttendances(studentId, subjectId), HttpStatus.OK);}

    @PostMapping("/addAttendance/{studentId}")
    public ResponseEntity<?> addGradeForSubject(@PathVariable int studentId, @RequestBody AddAttendanceDto addAttendanceDto) { return new ResponseEntity<>(attendanceService.addAttendance(studentId, addAttendanceDto), HttpStatus.OK);}

    @DeleteMapping("/deleteAttendance/{id}")
    public ResponseEntity<?> deleteGradeById(@PathVariable int id){ attendanceService.deleteAttendance(id); return new ResponseEntity<>(HttpStatus.OK); }

    @PutMapping("/updateAttendance")
    public  ResponseEntity<?> updateAttendance(@RequestBody AttendanceDto attendanceDto) { return new ResponseEntity<>(attendanceService.updateAttendance(attendanceDto), HttpStatus.OK);}

}
