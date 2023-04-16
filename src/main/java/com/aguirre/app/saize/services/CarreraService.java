package com.aguirre.app.saize.services;

import java.util.List;
import java.util.Optional;

import com.aguirre.app.saize.models.entity.Carrera;

public interface CarreraService {

	Carrera crear(Carrera carrera);
	Carrera modificar(Carrera carrera);
	void eliminarPorId(Long id);
	Optional<Carrera> buscarPorId(Long id);
	List<Carrera> buscarTodo();
	
	Optional<Carrera> buscarPorAbreviacion(String abreviacion);
}
