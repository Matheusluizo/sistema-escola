package com.matheusluizo.sistemaescola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusluizo.sistemaescola.entities.Turma;
import com.matheusluizo.sistemaescola.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public List<Turma> finAll(){
		return repository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional <Turma> obj = repository.findById(id);
		return obj.get();
	}
}
