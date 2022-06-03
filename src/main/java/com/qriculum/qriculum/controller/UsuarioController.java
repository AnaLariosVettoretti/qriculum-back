package com.qriculum.qriculum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qriculum.qriculum.beans.Usuario;
import com.qriculum.qriculum.repository.UsuarioRepository;
import com.qriculum.qriculum.utils.Cifrado;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("")
	List<Usuario> index() {
		return usuarioRepository.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Usuario create(@RequestBody Usuario usuario) {

		usuario.setContrasenia(Cifrado.getMD5(usuario.getContrasenia()));
		return usuarioRepository.save(usuario);
	}

	@GetMapping(path = "/{id}")
	Usuario getOne(@PathVariable("id") String username) {
		return this.usuarioRepository.findById(username).orElseThrow(RuntimeException::new);
	}

	@GetMapping(value = "/user")
	public Usuario validateUser(

	    @RequestParam(value = "id", required = true) String username,
		@RequestParam(value = "hash", required = true) String password
	    ) {
		
	    Usuario usuarioBBDD = this.usuarioRepository.findById(username).orElseThrow(RuntimeException::new);
	        
	    return usuarioBBDD;
	    /*    
	    String inputPass = Cifrado.getMD5(password);
	        
	        if (usuarioBBDD.getContrasenia() == inputPass) {
				return usuarioBBDD;
			}else {
				Usuario userVacio = new Usuario();
				return userVacio;
			}
			
		*/	
	}

	@PutMapping("{id}")
	Usuario update(@PathVariable String username, @RequestBody Usuario usuario) {
		Usuario usuarioBBDD = usuarioRepository.findById(username).orElseThrow(RuntimeException::new);
		usuarioBBDD.setUsuario(usuario.getUsuario());
		usuarioBBDD.setNombre(usuario.getNombre());
		usuarioBBDD.setApellido1(usuario.getApellido1());
		usuarioBBDD.setApellido2(usuario.getApellido2());
		usuarioBBDD.setEmail(usuario.getEmail());
		usuarioBBDD.setContrasenia(usuario.getContrasenia());
		usuarioBBDD.setTelefono1(usuario.getTelefono1());
		usuarioBBDD.setTelefono2(usuario.getTelefono2());
		usuarioBBDD.setCiudad(usuario.getCiudad());

		return usuarioRepository.save(usuarioBBDD);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void delete(String username) {
		Usuario usuarioBBDD = usuarioRepository.findById(username).orElseThrow(RuntimeException::new);

		usuarioRepository.delete(usuarioBBDD);
	}
}
