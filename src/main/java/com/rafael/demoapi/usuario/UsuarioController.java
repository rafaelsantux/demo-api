package com.rafael.demoapi.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{id}")
	public Usuario getOne(@PathVariable Long id) {
		if (usuarioRepository.existsById(id)) {
			return usuarioRepository.findById(id).get();
		}
		return null;
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public String delete(@PathVariable Long id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return "{\"status\" : \"deleted\" }";
		}
		return "{\"status\" : \"error\" }";
	}

	@PutMapping(path = "/{id}")
	public Usuario put(@PathVariable Long id, @RequestBody Usuario usuario) {
		return null;
	}

	@PatchMapping(path = "/{id}")
	public Usuario patch(@PathVariable Long id, @RequestBody Usuario usuario) {
		return null;
	}

	@PostMapping
	public Usuario post(@RequestBody Usuario user) {
		return usuarioRepository.save(user);
	}
}
