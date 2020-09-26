package com.matheusluizo.sistemaescola.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matheusluizo.sistemaescola.entities.Turma;
import com.matheusluizo.sistemaescola.repositories.TurmaRepository;
import com.matheusluizo.sistemaescola.services.exceptions.DatabaseException;
import com.matheusluizo.sistemaescola.services.exceptions.ResourceNotFoundException;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public List<Turma> finAll(){
		return repository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional <Turma> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Turma insert (Turma obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		try {					
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} 
	}
	public Turma update(Long id, Turma obj) {
		try {
		Turma entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Turma entity, Turma obj) {
		entity.setQuantidade(obj.getQuantidade());
		entity.settAno(obj.gettAno());
	}
}
