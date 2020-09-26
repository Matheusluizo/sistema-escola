package com.matheusluizo.sistemaescola.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matheusluizo.sistemaescola.entities.Professor;
import com.matheusluizo.sistemaescola.repositories.ProfessorRepository;
import com.matheusluizo.sistemaescola.services.exceptions.DatabaseException;
import com.matheusluizo.sistemaescola.services.exceptions.ResourceNotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> finAll(){
		return repository.findAll();
	}
	
	public Professor findById(Long id) {
		Optional <Professor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Professor insert (Professor obj) {
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
	public Professor update(Long id, Professor obj) {
		try {
		Professor entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Professor entity, Professor obj) {
		entity.setCpf(obj.getCpf());
		entity.setData(obj.getData());
		entity.setEndereço(obj.getEndereço());
		entity.setEspecializacao(obj.getEspecializacao());
		entity.setFormacao(obj.getFormacao());
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
	}
}
