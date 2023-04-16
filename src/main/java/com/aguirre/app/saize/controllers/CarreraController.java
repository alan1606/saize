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

import com.aguirre.app.saize.models.entity.Carrera;
import com.aguirre.app.saize.services.CarreraService;

@RestController
@RequestMapping("carreras")
public class CarreraController {

	@Autowired
	private CarreraService service;

	@GetMapping
	public ResponseEntity<?> buscarTodo() {
		return ResponseEntity.ok(service.buscarTodo());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Optional<Carrera> carreraOptional = service.buscarPorId(id);

		if (carreraOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(carreraOptional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Carrera carrera) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(carrera));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Carrera carrera) {
		Optional<Carrera> carreraOptional = service.buscarPorId(id);

		if (carreraOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Carrera carreraDb = carreraOptional.get();
		carreraDb.setAbreviacion(carrera.getAbreviacion());
		carreraDb.setNombre(carrera.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.modificar(carreraDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable  Long id){
		Optional<Carrera> carreraOptional = service.buscarPorId(id);

		if (carreraOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		service.eliminarPorId(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//Buscar por abreviacion
	@GetMapping("/abreviacion/{abreviacion}")
	public ResponseEntity<?> buscarPorAbreviacion(@PathVariable String abreviacion){
		Optional<Carrera> carreraOptional = service.buscarPorAbreviacion(abreviacion);
		
		if(carreraOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(carreraOptional.get());
	}
}

