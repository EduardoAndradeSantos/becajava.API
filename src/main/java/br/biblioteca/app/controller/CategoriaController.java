package br.biblioteca.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.biblioteca.app.model.Categoria;
import br.biblioteca.app.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	// PROPRIEDADES
	private final CategoriaService _service;

	// CONSTRUTOR
	public CategoriaController(CategoriaService service) {
		_service = service;
	}

	// CRIAR
	@PostMapping
	public ResponseEntity criar(@RequestBody Categoria categoria) {
		try {
			_service.criar(categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body("Categoria inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	// LISTAR TODOS
	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Categoria> categorias = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(categorias);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// LISTAR UM
	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {
			Optional<Categoria> categoria = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// ATUALIZAR UM
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Categoria categoria, @PathVariable Long id) {
		try {
			_service.atualizar(categoria, id);
			return ResponseEntity.status(HttpStatus.OK).body("Categoria atualizado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// DELETAR UM
	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		try {
			_service.deletar(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}
}