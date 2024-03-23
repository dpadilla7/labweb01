package com.dph.ms.proyectos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class ProyectoInvestigacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPryInv;
	private String titulo;
	@Temporal(TemporalType.DATE)
	private Date fechaInicioPry;
	@Temporal(TemporalType.DATE)
	private Date fechaCierrePry;
	private String estadoPry;
	private float presupuestoPry;
	
	private Investigador responsable;
	
	@ManyToMany(mappedBy = "proyectos")
	private List<Investigador> investigadores = new ArrayList<>();
	
	@OneToMany(mappedBy = "proyecto")
	private List<AvanceProyecto> avances = new ArrayList<>();

}
