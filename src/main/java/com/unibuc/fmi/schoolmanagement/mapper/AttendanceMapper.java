package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.AttendanceDto;
import com.unibuc.fmi.schoolmanagement.model.Attendance;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {

    public Attendance mapAttendanceDtoToAttendance(AttendanceDto attendanceDto){
        return Attendance.builder()
                .id(attendanceDto.getId())
                .date(attendanceDto.getDate())
                .build();
    }

    public AttendanceDto mapAttendanceToAttendanceDto(Attendance attendance){
        return AttendanceDto.builder()
                .id(attendance.getId())
                .date(attendance.getDate())
                .build();
    }
}
