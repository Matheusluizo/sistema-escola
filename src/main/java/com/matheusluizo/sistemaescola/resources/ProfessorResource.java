package com.matheusluizo.sistemaescola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusluizo.sistemaescola.entities.Professor;
import com.matheusluizo.sistemaescola.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity <List<Professor>> findAll() {
		List<Professor> list = service.finAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Long id){
		Professor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
