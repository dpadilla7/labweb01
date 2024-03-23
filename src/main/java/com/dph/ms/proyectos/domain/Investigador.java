package com.dph.ms.proyectos.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
public class Investigador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idInvestigador;
	private String apePat;
	private String apeMat;
	private String nombres;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String dni;
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	
	@ManyToMany
	@JoinTable(name = "InvestigadoresProyectos",
				joinColumns = @JoinColumn(name ="idInvestigador"),
				inverseJoinColumns = @JoinColumn(name="idPryInv")
				)
	private List<ProyectoInvestigacion> proyectos = new ArrayList<>();
	

}
