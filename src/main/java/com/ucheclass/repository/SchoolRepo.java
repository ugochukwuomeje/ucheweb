package com.ucheclass.repository;

import com.ucheclass.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRepo extends JpaRepository<School, BigInteger> {

    @Query("from School where name = ?1")
    Optional<List<School>> findAllByName(String name);
}
