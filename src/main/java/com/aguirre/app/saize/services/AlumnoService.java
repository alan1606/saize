package com.aguirre.app.saize.services;

import java.util.List;
import java.util.Optional;

import com.aguirre.app.saize.models.entity.Alumno;

public interface AlumnoService {

	Alumno crear(Alumno alumno);
	Alumno modificar(Alumno alumno);
	void eliminarPorId(Long id);
	Optional<Alumno> buscarPorId(Long id);
	List<Alumno> encontrarTodo(); 
	List<Alumno> buscarPorGrupoId(Long grupoId);
	List<Alumno> buscarPorNombre(String nombre);
}
