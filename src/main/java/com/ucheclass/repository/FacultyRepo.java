package com.ucheclass.repository;

import com.ucheclass.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, BigInteger> {

    public Optional<List<Faculty>> findBySchoolId(BigInteger bigInteger);
}
