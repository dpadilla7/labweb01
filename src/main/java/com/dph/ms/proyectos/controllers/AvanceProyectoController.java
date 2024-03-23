package com.dph.ms.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dph.ms.proyectos.domain.AvanceProyecto;
import com.dph.ms.proyectos.services.AvanceProyectoService;

@RestController
@RequestMapping("/api/v1/avances")
public class AvanceProyectoController {
	@Autowired
	private AvanceProyectoService avaService;
	
	@GetMapping
	public List<AvanceProyecto> listarAvanceProyecto(){
		return avaService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public AvanceProyecto listarPorId(@PathVariable Long id){
		return avaService.buscarPorId(id);
	}
	
	@PostMapping
	public AvanceProyecto crearAvanceProyecto(@RequestBody AvanceProyecto avanproy) {
		return avaService.grabar(avanproy);
	}
	
	@PutMapping ("/{id}")
	public AvanceProyecto editarAvanceProyecto(@PathVariable Long id, @RequestBody AvanceProyecto ava) {
		AvanceProyecto avaDB = avaService.buscarPorId(id);
		
		avaDB.setDescripcionAvance(ava.getDescripcionAvance());
		avaDB.setEstadoAv(ava.getEstadoAv());
		avaDB.setFechaREgAvance(ava.getFechaREgAvance());
		avaDB.setPesupuestoGastado(ava.getPesupuestoGastado());
		avaDB.setPresupuestoAsigado(ava.getPresupuestoAsigado());
		
		avaDB.setProyecto(ava.getProyecto());
		
		return avaService.grabar(avaDB);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarAvanceProyecto(@PathVariable Long id) {
		avaService.eliminar(id);
	}

}
