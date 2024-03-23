package com.dph.ms.proyectos.domain;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class AvanceProyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvance;
	private String descripcionAvance;
	@Temporal(TemporalType.DATE)
	private Date fechaREgAvance;
	private String estadoAv;
	private float presupuestoAsigado;
	private float pesupuestoGastado;
	@ManyToOne
	private ProyectoInvestigacion proyecto;

}
