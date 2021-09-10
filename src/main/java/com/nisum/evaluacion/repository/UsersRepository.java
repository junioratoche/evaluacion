package com.nisum.evaluacion.repository;

import com.nisum.evaluacion.model.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);
}

