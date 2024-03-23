package com.dph.ms.proyectos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dph.ms.proyectos.domain.Investigador;
import com.dph.ms.proyectos.exception.EntityNotFoundException;
import com.dph.ms.proyectos.exception.IllegalOperationException;
import com.dph.ms.proyectos.services.InvestigadorService;

@RestController
@RequestMapping("/api/v1/investigadores")
public class InvestigadorController {
	@Autowired
	private InvestigadorService invService;
	
	@GetMapping
	public List<Investigador> listarInvestigadores(){
		return invService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		Optional<Investigador> invOptional = Optional.ofNullable(invService.buscarPorId(id));
		if(invOptional.isPresent()) {
			return ResponseEntity.ok(invOptional.get());
		}
		return ResponseEntity.notFound().build();
		
		//return invService.buscarPorId(id);
	}
	
	@PostMapping
	public ResponseEntity<?> crearInvestigador(@RequestBody Investigador investigador) throws IllegalOperationException {
		return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabar(investigador));
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> editarInvestigador(@PathVariable Long id, @RequestBody Investigador inv) throws IllegalOperationException {
		
		Optional<Investigador> o = Optional.ofNullable(invService.buscarPorId(id));
		if (o.isPresent()) {
			Investigador invDB = o.get();
			invDB.setApePat(inv.getApePat());
			invDB.setApeMat(inv.getApeMat());
			invDB.setEmail(inv.getEmail());
			invDB.setDni(inv.getDni());
			invDB.setFechaReg(inv.getFechaReg());
			invDB.setNombres(inv.getNombres());
						
			return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabar(invDB));
			
		}
		return ResponseEntity.notFound().build();
		
		/*Investigador invDB = invService.buscarPorId(id);
		invDB.setApeMat(inv.getApeMat());
		invDB.setApePat(inv.getApePat());
		invDB.setDni(inv.getDni());
		invDB.setEmail(inv.getEmail());
		invDB.setFechaReg(inv.getFechaReg());
		invDB.setNombres(inv.getNombres());
		return invService.grabar(invDB);*/
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarInvestigador(@PathVariable Long id) throws EntityNotFoundException, IllegalOperationException {
		
		Optional<Investigador> o = Optional.of(invService.buscarPorId(id));
		if (o.isPresent()) {
			invService.eliminar(id);
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.notFound().build();
		
		//invService.eliminar(id);
	}
	


}
