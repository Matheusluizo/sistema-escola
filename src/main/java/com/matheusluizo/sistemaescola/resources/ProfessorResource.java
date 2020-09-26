package com.matheusluizo.sistemaescola.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Professor> insert (@RequestBody Professor obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{i}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Professor> update (@PathVariable Long id, @RequestBody Professor obj){
		 obj = service.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	}
}
