package com.idat.ProfesorMicroservicioIIIE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;

	private String nombres;
	
	private String apellidos;
	
}
