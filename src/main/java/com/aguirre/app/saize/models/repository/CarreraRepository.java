package com.aguirre.app.saize.models.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguirre.app.saize.models.entity.Carrera;

@Repository
public interface CarreraRepository
extends CrudRepository<Carrera, Long>
{
	Optional<Carrera> findByAbreviacion(String abreviacion);
}
