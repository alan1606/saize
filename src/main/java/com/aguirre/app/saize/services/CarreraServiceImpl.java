package com.aguirre.app.saize.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguirre.app.saize.models.entity.Carrera;
import com.aguirre.app.saize.models.repository.CarreraRepository;

@Service
public class CarreraServiceImpl implements CarreraService{

	@Autowired
	private CarreraRepository repository;
	
	@Override
	public Carrera crear(Carrera carrera) {
		return repository.save(carrera);
	}

	@Override
	public Carrera modificar(Carrera carrera) {
		return repository.save(carrera);
	}

	@Override
	public void eliminarPorId(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Carrera> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Carrera> buscarTodo() {
		return (List<Carrera>) repository.findAll();
	}

	@Override
	public Optional<Carrera> buscarPorAbreviacion(String abreviacion) {
		return repository.findByAbreviacion(abreviacion);
	}

}
