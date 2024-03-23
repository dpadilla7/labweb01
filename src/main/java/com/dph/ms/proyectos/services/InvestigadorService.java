package com.dph.ms.proyectos.services;

import java.util.List;

import com.dph.ms.proyectos.domain.Investigador;
import com.dph.ms.proyectos.exception.EntityNotFoundException;
import com.dph.ms.proyectos.exception.IllegalOperationException;

public interface InvestigadorService {
	List<Investigador> listarTodos();
	Investigador buscarPorId(Long id);
	Investigador grabar(Investigador investigador) throws IllegalOperationException;
	Investigador  actualizar (Investigador investigador, Long id) throws EntityNotFoundException, IllegalOperationException;
	void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException;
	Investigador findByDni (String dni);
	Investigador finByEmail (String email);
}
