package com.ucheclass.entity;

import com.ucheclass.enums.SchoolCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "school")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class School {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id", nullable = false, columnDefinition = "bigint(15)")
    private BigInteger id;

    @NotNull
    @Column(name="name", nullable = false, columnDefinition = "varchar(500)")
    private String name;

    @Enumerated(EnumType.STRING)
    private SchoolCategory schoolCategory;

    @OneToMany(mappedBy = "schoolId")
    private List<Course> course;

}
