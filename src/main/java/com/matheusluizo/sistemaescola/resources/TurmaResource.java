package com.matheusluizo.sistemaescola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusluizo.sistemaescola.entities.Turma;
import com.matheusluizo.sistemaescola.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {
	
	@Autowired
	private TurmaService service;
	
	@GetMapping
	public ResponseEntity <List<Turma>> findAll() {
		List<Turma> list = service.finAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Long id){
		Turma obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
