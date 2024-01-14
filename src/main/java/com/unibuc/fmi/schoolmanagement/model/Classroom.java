package com.unibuc.fmi.schoolmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int floor;
    private boolean isLaboratory;
    private String name;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TeacherClassroom> teachers;
}
