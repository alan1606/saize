/**
 * 
 */
package com.aguirre.app.saize.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguirre.app.saize.models.entity.Grupo;

@Repository
public interface GrupoRepository 
extends CrudRepository<Grupo, Long>
{

	@Query("select g from Grupo g where g.carrera.id = ?1")
	List<Grupo> buscarPorCarreraId(Long carreraId);
	
	@Query("select g from Grupo g where g.aula = ?1")
	Optional<Grupo> buscarPorAula(String aulaId);
	
}
