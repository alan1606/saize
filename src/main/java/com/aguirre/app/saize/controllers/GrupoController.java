package com.aguirre.app.saize.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguirre.app.saize.models.entity.Grupo;
import com.aguirre.app.saize.services.GrupoService;

@RestController
@RequestMapping("grupos")
public class GrupoController {

	@Autowired
	private GrupoService service;

	@GetMapping
	public ResponseEntity<?> buscarTodo() {
		return ResponseEntity.ok(service.buscarTodo());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Optional<Grupo> grupoOptional = service.buscarPorId(id);

		if (grupoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(grupoOptional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Grupo grupo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(grupo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Grupo grupo) {
		Optional<Grupo> grupoOptional = service.buscarPorId(id);

		if (grupoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Grupo grupoDb = grupoOptional.get();
		grupoDb.setAnio(grupo.getAnio());
		grupoDb.setAula(grupo.getAula());
		grupoDb.setCarrera(grupo.getCarrera());
		grupoDb.setNombre(grupo.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.modificar(grupoDb));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
		Optional<Grupo> grupoOptional = service.buscarPorId(id);

		if (grupoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		service.eliminarPorId(id);
		
		return ResponseEntity.noContent().build();
	}
	
	//Un método get para buscar los grupos que tiene la carrera X
	@GetMapping("/carrera/{carreraId}")
	public ResponseEntity<?> buscarGruposPorCarreraId(@PathVariable Long carreraId){
		return ResponseEntity.ok(service.buscarPorCarreraId(carreraId));
	}
	
	
	//Buscar por aula
	@GetMapping("/aula/{aula}")
	public ResponseEntity<?> buscarPorAulaId(@PathVariable String aula){
		Optional<Grupo> grupoOptional = service.buscarPorAula(aula);
		
		if(grupoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(grupoOptional.get());
	}
}
