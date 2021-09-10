package com.nisum.evaluacion.repository;

import com.nisum.evaluacion.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}