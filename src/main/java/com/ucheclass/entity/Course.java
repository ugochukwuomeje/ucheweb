package com.ucheclass.entity;

import com.ucheclass.enums.CourseStatus;
import com.ucheclass.enums.Level;
import com.ucheclass.enums.CourseCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name="course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id", nullable = false, columnDefinition = "bigint(18)")
    private BigInteger id;
    @Column(name = "course_code", nullable = false, columnDefinition = "varchar(500)")
    private String courseCode;
    @Column(name = "course_title", nullable = false, columnDefinition = "varchar(500)")
    private String courseTitle;
    @ManyToOne()
    @JoinColumn(name = "schoolId")
    private School schoolId;
    @Enumerated(EnumType.STRING)
    private Level level;

    @Enumerated(EnumType.STRING)
    private CourseCategory courseCategory;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private Users users;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;
}
