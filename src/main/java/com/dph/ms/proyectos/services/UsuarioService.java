package com.dph.ms.proyectos.services;

import java.util.List;

import com.dph.ms.proyectos.domain.Usuario;

public interface UsuarioService {
	List<Usuario> listarTodos();
	Usuario buscarPorId(Long id);
	Usuario grabar(Usuario usuario);
	Usuario  actualizar (Usuario usuario, Long id);
	void eliminar(Long id);
	Usuario finByEmail (String email);
}
