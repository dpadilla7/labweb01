package com.dph.ms.proyectos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dph.ms.proyectos.domain.ProyectoInvestigacion;

public interface ProyectoRepository extends JpaRepository<ProyectoInvestigacion, Long> {

}
