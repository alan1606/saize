package com.aguirre.app.saize.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Se le indica que la clase es una
//tabla de la base de datos
@Entity
@Table(name = "carreras")
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(unique = true)
	private String abreviacion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviacion() {
		return abreviacion;
	}
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}
	
	
}
