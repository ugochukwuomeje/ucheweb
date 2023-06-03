package com.ucheclass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "faculty")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint(10)")
    private BigInteger id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(500)")
    private String name;

    @Column(name = "schoolId", nullable = false, columnDefinition = "bigint(10)")
    private BigInteger schoolId;

}
