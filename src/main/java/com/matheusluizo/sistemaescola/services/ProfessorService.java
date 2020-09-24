package com.matheusluizo.sistemaescola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusluizo.sistemaescola.entities.Professor;
import com.matheusluizo.sistemaescola.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> finAll(){
		return repository.findAll();
	}
	
	public Professor findById(Long id) {
		Optional <Professor> obj = repository.findById(id);
		return obj.get();
	}
}
