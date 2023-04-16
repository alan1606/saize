package com.aguirre.app.saize.services;

import java.util.List;
import java.util.Optional;

import com.aguirre.app.saize.models.entity.Grupo;

public interface GrupoService {

	Grupo crear(Grupo grupo);
	Grupo modificar(Grupo grupo);
	void eliminarPorId(Long id);
	Optional<Grupo> buscarPorId(Long id);
	List<Grupo> buscarTodo();
	List<Grupo> buscarPorCarreraId(Long carreraId);
	Optional<Grupo> buscarPorAula(String  aula);
}
