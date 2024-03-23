package com.dph.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dph.ms.proyectos.domain.AvanceProyecto;
import com.dph.ms.proyectos.repositories.AvanceRepository;

@Service
public class AvanceProyectoServiceImpl implements AvanceProyectoService {

	@Autowired
	private AvanceRepository avaRep;
	
	@Override
	@Transactional
	public List<AvanceProyecto> listarTodos() {
		return avaRep.findAll();
	}

	@Override
	@Transactional
	public AvanceProyecto buscarPorId(Long id) {
		Optional<AvanceProyecto> avance = avaRep.findById(id);
		return avance.get();
	}

	@Override
	@Transactional
	public AvanceProyecto grabar(AvanceProyecto avance) {
		return avaRep.save(avance);
	}

	@Override
	@Transactional
	public AvanceProyecto actualizar(AvanceProyecto avance, Long id) {
		avance.setIdAvance(id);
		return avaRep.save(avance);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		avaRep.deleteById(id);
		
	}

}
