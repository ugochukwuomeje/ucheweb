package com.ucheclass.repository;

import com.ucheclass.entity.Course;
import com.ucheclass.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CourseRepo extends JpaRepository<Course, BigInteger> {
}
