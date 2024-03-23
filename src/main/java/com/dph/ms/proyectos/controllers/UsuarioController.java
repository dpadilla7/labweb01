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

import com.dph.ms.proyectos.domain.Usuario;
import com.dph.ms.proyectos.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usrService;
	
	@GetMapping
	public List<Usuario> listarUsuario(){
		return usrService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public Usuario listarPorId(@PathVariable Long id){
		return usrService.buscarPorId(id);
	}
	
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario){
		return usrService.grabar(usuario);
	}
	
	@PutMapping ("/{id}")
	public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario usr){
		Usuario usrDB = usrService.buscarPorId(id);
		
		usrDB.setEmail(usr.getEmail());
		usrDB.setPassword(usr.getPassword());
		
		usrDB.setRol(usr.getRol());
		
		return usrService.grabar(usrDB);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarUsario(@PathVariable Long id) {
		usrService.eliminar(id);
	}
	

}
