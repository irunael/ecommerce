package com.revisao.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.UsuarioDTO;
import com.revisao.ecommerce.entities.Usuario;
import com.revisao.ecommerce.repositories.UsuarioRepository;



@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PasswordEncoder config;
	
	public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(config.encode(dto.getSenha()));
		usuario.setNome(dto.getNome());
		usuario.setTelefone(dto.getTelefone());
		
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}
	
	public boolean login(UsuarioDTO dto) {
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
		
		if (usuario == null) {
			return false;
		}
		
		
		return config.matches(dto.getSenha(), usuario.getSenha());
	}
}
