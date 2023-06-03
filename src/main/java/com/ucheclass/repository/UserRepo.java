package com.ucheclass.repository;

import com.ucheclass.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, BigInteger> {

    public Optional<Users> findUserByEmail(String email);
}
