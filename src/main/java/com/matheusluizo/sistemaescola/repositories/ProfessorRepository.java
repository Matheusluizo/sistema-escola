package com.matheusluizo.sistemaescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusluizo.sistemaescola.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
