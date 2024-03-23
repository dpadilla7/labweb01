package com.dph.ms.proyectos.services;

import java.util.List;

import com.dph.ms.proyectos.domain.AvanceProyecto;

public interface AvanceProyectoService {
	List<AvanceProyecto> listarTodos();
	AvanceProyecto buscarPorId(Long id);
	AvanceProyecto grabar(AvanceProyecto avance);
	AvanceProyecto  actualizar (AvanceProyecto avance, Long id);
	void eliminar(Long id);
}
