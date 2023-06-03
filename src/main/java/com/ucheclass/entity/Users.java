package com.ucheclass.entity;

import com.ucheclass.enums.UserPosition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @Column(name="id", nullable = false, columnDefinition = "bigint(18)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "email", nullable = false, columnDefinition = "varchar(500)")
    private String email;
    @Column(name = "school", nullable = false, columnDefinition = "varchar(500)")
    private String school;
    @Column(name = "country", nullable = false, columnDefinition = "varchar(100)")
    private String country;
    @Column(name = "password",  columnDefinition = "varchar(100)")
    private String password;

    @Column(name = "phone_number",  columnDefinition = "varchar(13)")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserPosition userPosition;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Course> course;



}
