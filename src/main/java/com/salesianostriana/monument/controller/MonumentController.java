package com.salesianostriana.monument.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.monument.exception.MonumentNotFoundException;
import com.salesianostriana.monument.model.Monument;
import com.salesianostriana.monument.service.MonumentService;

@RestController
public class MonumentController {

	@Autowired
	private MonumentService monumentService;

	// ListAll
	@GetMapping("/monumentos")
	public List<Monument> showAll() {
		return monumentService.findAll();
	}

	// FindOne
	@GetMapping("/monumentos/{id}")
	public Monument showOne(@PathVariable Long id) {
		return monumentService.findById(id).orElseThrow(() -> new MonumentNotFoundException(id));
	}

	// AddNew
	@PostMapping("/monumentos")
	public ResponseEntity<?> newMonument(@RequestBody Monument newMonument) {
		Monument monument = monumentService.save(newMonument);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(monument.getId())
				.toUri();

		return ResponseEntity.created(location).body(monument);
	}

	// EditOneOrAdd
	@PutMapping("/monumentos")
	public ResponseEntity<?> replaceMonument(@RequestBody Monument newMonument) {

		Monument updated = monumentService.findById(newMonument.getId()).map(monument -> {
			monument.setCiudad(newMonument.getCiudad());
			monument.setCodigoPais(newMonument.getCodigoPais());
			monument.setDescripcion(newMonument.getDescripcion());
			monument.setLocalizacion(newMonument.getLocalizacion());
			monument.setNombre(newMonument.getNombre());
			monument.setPais(newMonument.getPais());
			monument.setUrlImagen(newMonument.getUrlImagen());
			return monumentService.save(monument);
		}).orElseGet(() -> {
			return monumentService.save(newMonument);
		});

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updated.getId())
				.toUri();

		return ResponseEntity.created(location).body(updated);
	}

	// RemoveOne
	@DeleteMapping("/monumentos/{id}")
	public void deleteMonument(@PathVariable Long id) {
		monumentService.deleteById(id);
	}
	
}
