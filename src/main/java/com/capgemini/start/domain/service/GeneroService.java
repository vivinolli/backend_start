package com.capgemini.start.domain.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

public abstract class GeneroService <G, ID> {
protected abstract JpaRepository<G, ID> getRepository();
	
	public G findById(ID id) {
		return getRepository().findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto encontrado"));
	}
	
	public G insert(G entity) {
		return getRepository().save(entity);
	}
	
	public G update(G entity) {
		return getRepository().save(entity);
	}
	
	public void delete(ID id) {
		if (!getRepository().existsById(id)) {
			throw new ObjectNotFoundException("Objeto encontrado");
		}
		getRepository().deleteById(id);
	}
	
	public List<G> findAll(){
		return getRepository().findAll();
	}

}
