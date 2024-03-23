package com.dph.ms.proyectos.services;

import java.util.List;

import com.dph.ms.proyectos.domain.ProyectoInvestigacion;

public interface ProyectoInvestigacionService {
	List<ProyectoInvestigacion> listarTodos();
	ProyectoInvestigacion buscarPorId(Long id);
	ProyectoInvestigacion grabar(ProyectoInvestigacion proyecto);
	ProyectoInvestigacion  actualizar (ProyectoInvestigacion proyecto, Long id);
	void eliminar(Long id);
}
