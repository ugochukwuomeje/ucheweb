package com.ucheclass.repository;

import com.ucheclass.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    @Query("from Department where school = ?1 and faculty = ?2")
    public Optional<List<Department>> findBySchoolAndfaculty(BigInteger school, BigInteger faculty);
}
