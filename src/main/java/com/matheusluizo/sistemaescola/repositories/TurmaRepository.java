package com.matheusluizo.sistemaescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusluizo.sistemaescola.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
