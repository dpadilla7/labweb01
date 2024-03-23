package com.dph.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dph.ms.proyectos.domain.Investigador;
import com.dph.ms.proyectos.exception.EntityNotFoundException;
import com.dph.ms.proyectos.exception.EntityNotFoundExceptionMessages;
import com.dph.ms.proyectos.exception.IllegalOperationException;
import com.dph.ms.proyectos.repositories.InvestigadorRepository;


@Service
public class InvestigadorServiceImp implements InvestigadorService {
	//invRep inyeccion dependdencia
	@Autowired
	private InvestigadorRepository invRep;
	

	@Override
	@Transactional
	public List<Investigador> listarTodos() {
		return invRep.findAll();
		
	}

	@Override
	@Transactional
	public Investigador buscarPorId(Long id) throws EntityNotFoundException {
		Optional<Investigador> investigador = invRep.findById(id);
		if(investigador.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return investigador.get();
		
	}

	@Override
	@Transactional
	public Investigador grabar(Investigador investigador) throws IllegalOperationException {
		if(!invRep.findByEmail(investigador.getEmail()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un investigador con ese email");
		}
		if(!invRep.findByDni(investigador.getDni()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un investigador con ese dni");
		}
		return invRep.save(investigador);
		
	}

	@Override
	@Transactional
	public Investigador actualizar(Investigador investigador, Long id) throws EntityNotFoundException, IllegalOperationException {
		
		Optional<Investigador> invEntity = invRep.findById(id);
		if (invEntity.isEmpty()) {
            throw new EntityNotFoundException("El investigador no existe");
        }
        if (!invRep.findByEmail(investigador.getEmail()).isEmpty()) {
            throw new IllegalOperationException("El email del investigador ya existe");
        }
        if (!invRep.findByDni(investigador.getDni()).isEmpty()) {
            throw new IllegalOperationException("El dni del investigador ya existe");
        }
		investigador.setIdInvestigador(id);		
		return invRep.save(investigador);
		
	}

	@Override
	@Transactional
	public void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException {
		Investigador inv = invRep.findById(id).orElseThrow(
				()->new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND)
				);	
		invRep.deleteById(id);

	}

	@Override
	@Transactional
	public Investigador findByDni(String dni) {
		Optional<Investigador> investigador = invRep.findByDni(dni);
		if(investigador.isEmpty())throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return investigador.get();
	}

	@Override
	@Transactional
	public Investigador finByEmail(String email) {
		Optional<Investigador> investigador = invRep.findByEmail(email);
		if(investigador.isEmpty())throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return investigador.get();
		//return invRep.findByEmail(email).get();
	}

}
