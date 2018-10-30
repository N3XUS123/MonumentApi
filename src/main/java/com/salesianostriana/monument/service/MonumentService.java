package com.salesianostriana.monument.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.monument.model.Monument;
import com.salesianostriana.monument.repository.MonumentRepository;

@Service
public class MonumentService {

	@Autowired
	private MonumentRepository repo;
	
	public List<Monument> findAll(){
		return repo.findAll();
	}
	
	public Optional<Monument> findById(Long id) {
		return repo.findById(id);
	}
	
	public Monument save(Monument newMonument) {
		return repo.save(newMonument);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
		
	}
}
