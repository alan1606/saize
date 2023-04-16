package com.aguirre.app.saize.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguirre.app.saize.models.entity.Alumno;

@Repository
public interface AlumnoRepository 
extends CrudRepository<Alumno, Long>
{
	//Select * from alumnos where alumnos.grupo_id=?1
	@Query("select a from Alumno a where a.grupo.id=?1 ")
	List<Alumno> buscarPorGrupoId(Long grupoId);
	
	
	//select * from nombre where concat(upper(nombre), ' ' , upper(apellido)) like '%upper(asd)%'
	@Query("select a from Alumno a where concat(upper(a.nombres), ' ' , upper(a.apellidos))"
			+ "  like concat('%', upper(?1),'%')")
	List<Alumno> buscarPorNombre(String nombre); 
}
