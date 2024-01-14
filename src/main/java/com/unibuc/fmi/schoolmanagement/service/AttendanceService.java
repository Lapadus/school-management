package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.AddAttendanceDto;
import com.unibuc.fmi.schoolmanagement.dto.AttendanceDto;
import com.unibuc.fmi.schoolmanagement.mapper.AttendanceMapper;
import com.unibuc.fmi.schoolmanagement.model.*;
import com.unibuc.fmi.schoolmanagement.repository.AttendanceRepository;
import com.unibuc.fmi.schoolmanagement.repository.StudentRepository;
import com.unibuc.fmi.schoolmanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, AttendanceMapper attendanceMapper, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.attendanceRepository = attendanceRepository;
        this.attendanceMapper = attendanceMapper;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<AttendanceDto> getAttendances(int studentId, int subjectId) {
        List<Attendance> attendancesForStudent = attendanceRepository.getAttendancesByStudentIdAndSubjectId(studentId, subjectId).get();
        List<AttendanceDto> attendanceDtos = new ArrayList<>();
        AttendanceDto attendanceDto = null;
        for(Attendance attendance: attendancesForStudent) {
            attendanceDto = attendanceMapper.mapAttendanceToAttendanceDto(attendance);
            attendanceDtos.add(attendanceDto);
        }
        return attendanceDtos;
    }

    public int addAttendance(int studentId, AddAttendanceDto addAttendanceDto){
        Student student = studentRepository.findById(studentId).get();
        Subject subject = subjectRepository.findById(addAttendanceDto.getSubjectId()).get();
        Attendance newAttendance = Attendance.builder()
                .student(student)
                .subject(subject)
                .date(addAttendanceDto.getDate())
                .build();
        return attendanceRepository.save(newAttendance).getId();
    }

    public void deleteAttendance(int id) {
        boolean exists = attendanceRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("grade with "+ id +" doesn't exist");
        }
        attendanceRepository.deleteById(id);
    }

    public int updateAttendance(AttendanceDto attendanceDto){
        boolean exists = attendanceRepository.existsById(attendanceDto.getId());
        if(!exists){
            throw new IllegalStateException("attendanceDto with "+ attendanceDto.getId() +" doesn't exist");
        }
        Attendance newAttendance = attendanceMapper.mapAttendanceDtoToAttendance(attendanceDto);
        return attendanceRepository.save(newAttendance).getId();
    }
}
