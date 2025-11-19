package com.javeriana.clinicas_backend.repository;

import com.javeriana.clinicas_backend.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
}
