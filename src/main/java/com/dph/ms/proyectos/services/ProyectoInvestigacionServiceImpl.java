package com.dph.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dph.ms.proyectos.domain.ProyectoInvestigacion;
import com.dph.ms.proyectos.repositories.ProyectoRepository;

@Service
public class ProyectoInvestigacionServiceImpl implements ProyectoInvestigacionService {

	@Autowired
	private ProyectoRepository proyRep;
	
	@Override
	@Transactional
	public List<ProyectoInvestigacion> listarTodos() {
		return proyRep.findAll();
	}

	@Override
	@Transactional
	public ProyectoInvestigacion buscarPorId(Long id) {
		Optional<ProyectoInvestigacion> proyecto = proyRep.findById(id);
		return proyecto.get();
	}

	@Override
	@Transactional
	public ProyectoInvestigacion grabar(ProyectoInvestigacion proyecto) {
		return proyRep.save(proyecto);
	}

	@Override
	@Transactional
	public ProyectoInvestigacion actualizar(ProyectoInvestigacion proyecto, Long id) {
		proyecto.setIdPryInv(id);
		return proyRep.save(proyecto);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		proyRep.deleteById(id);

	}

}
