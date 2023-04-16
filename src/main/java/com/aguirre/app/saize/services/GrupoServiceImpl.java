package com.aguirre.app.saize.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguirre.app.saize.models.entity.Grupo;
import com.aguirre.app.saize.models.repository.GrupoRepository;

@Service
public class GrupoServiceImpl implements GrupoService {

	@Autowired
	private GrupoRepository repository;
	
	@Override
	public Grupo crear(Grupo grupo) {
		return repository.save(grupo);
	}

	@Override
	public Grupo modificar(Grupo grupo) {
		return repository.save(grupo);
	}

	@Override
	public void eliminarPorId(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Grupo> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Grupo> buscarTodo() {
		return (List<Grupo>) repository.findAll();
	}

	@Override
	public List<Grupo> buscarPorCarreraId(Long carreraId) {
		return repository.buscarPorCarreraId(carreraId);
	}

	@Override
	public Optional<Grupo> buscarPorAula(String aulaId) {
		return repository.buscarPorAula(aulaId);
	}

}
