package com.aguirre.app.saize.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguirre.app.saize.models.entity.Alumno;
import com.aguirre.app.saize.services.AlumnoService;

@RestController
@RequestMapping("alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@GetMapping
	public ResponseEntity<?> encontrarTodo() {
		return ResponseEntity.ok(service.encontrarTodo());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Long id) {
		Optional<Alumno> alumnoOptional = service.buscarPorId(id);

		if (alumnoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Alumno encontrado = alumnoOptional.get();
		return ResponseEntity.ok(encontrado);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
		Alumno creado = service.crear(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Alumno alumno) {
		Optional<Alumno> alumnoOptional = service.buscarPorId(id);

		if (alumnoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Alumno encontrado = alumnoOptional.get();
		encontrado.setApellidos(alumno.getApellidos());
		encontrado.setFechaNacimiento(alumno.getFechaNacimiento());
		encontrado.setGrupo(alumno.getGrupo());
		encontrado.setMatricula(alumno.getMatricula());
		encontrado.setNombres(alumno.getNombres());
		encontrado.setSexo(alumno.getSexo());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.modificar(alumno));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
		Optional<Alumno> alumnoOptional = service.buscarPorId(id);

		if (alumnoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		service.eliminarPorId(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	//Un método para buscar qué alumnos existen en cierto grupo
	@GetMapping("/grupo/{grupoId}")
	public ResponseEntity<?> buscarAlumnosEnGrupo(@PathVariable Long grupoId){
		return ResponseEntity.ok(service.buscarPorGrupoId(grupoId));
	}
	
	//Buscar por nombre
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre){
		return ResponseEntity.ok(service.buscarPorNombre(nombre));
	}
}
