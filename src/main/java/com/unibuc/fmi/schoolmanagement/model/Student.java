package com.unibuc.fmi.schoolmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unibuc.fmi.schoolmanagement.enums.EProfile;
import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String email;
    private EProfile profile;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books;

    @ManyToOne
    private Classroom classroom;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Grade> grades;

    public Student(String lastName, String firstName, String email, EProfile profile, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.profile = profile;
        this.age = age;
    }

//    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
//    private List<Attendance> attendances;
}
