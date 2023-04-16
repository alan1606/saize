package com.aguirre.app.saize.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aguirre.app.saize.models.entity.Alumno;
import com.aguirre.app.saize.models.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	@Transactional
	public Alumno crear(Alumno alumno) {
		return repository.save(alumno);
	}

	@Override
	public Alumno modificar(Alumno alumno) {
		return repository.save(alumno);
	}

	@Override
	public void eliminarPorId(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> encontrarTodo() {
		return (List<Alumno>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> buscarPorGrupoId(Long grupoId) {
		return repository.buscarPorGrupoId(grupoId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> buscarPorNombre(String nombre) {
		return repository.buscarPorNombre(nombre);
	}

}
