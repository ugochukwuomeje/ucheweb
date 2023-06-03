package com.ucheclass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint(18)")
    private BigInteger id;
    @Column(name="department", columnDefinition = "varchar(255)")
    @NotNull(message="Department cannot be empty")
    private String departmentName;

    @NotNull(message = "faculty cannot be empty")
    @Column(name="faculty", columnDefinition = "bigint(10)")
    private BigInteger faculty;

    @NotNull(message = "School cannot be empty")
    @Column(name="school", columnDefinition = "bigint(10)")
    private BigInteger school;

}
