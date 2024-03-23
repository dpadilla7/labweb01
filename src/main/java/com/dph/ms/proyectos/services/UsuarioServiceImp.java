package com.dph.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dph.ms.proyectos.domain.Usuario;
import com.dph.ms.proyectos.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usrRep;
	
	@Override
	@Transactional
	public List<Usuario> listarTodos() {
		return usrRep.findAll();
	}

	@Override
	@Transactional
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = usrRep.findById(id);
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario grabar(Usuario usuario) {
		return usrRep.save(usuario);
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usuario, Long id) {
		 usuario.setId(id);
		return usrRep.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		usrRep.deleteById(id);

	}

	@Override
	@Transactional
	public Usuario finByEmail(String email) {
		return usrRep.findByEmail(email).get();
	}

}
