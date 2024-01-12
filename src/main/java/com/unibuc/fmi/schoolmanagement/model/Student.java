package com.unibuc.fmi.schoolmanagement.model;

import com.unibuc.fmi.schoolmanagement.enums.EProfile;
import jakarta.validation.constraints.Min;
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
    @Min(7)
    @NonNull
    private int age;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    private EProfile profile;

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Grades> grades;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Attendance> attendances;
}
