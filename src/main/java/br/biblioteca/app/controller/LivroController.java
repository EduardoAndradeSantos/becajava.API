package br.biblioteca.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.biblioteca.app.model.Livro;
import br.biblioteca.app.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	// PROPRIEDADES
	private final LivroService _service;

	// CONSTRUTOR
	public LivroController(LivroService service) {
		_service = service;
	}

	// CRIAR
	@PostMapping
	public ResponseEntity criar(@RequestBody Livro livro) {
		try {
			_service.criar(livro);
			return ResponseEntity.status(HttpStatus.CREATED).body("Livro inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// LISTAR TODOS
	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Livro> livros = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(livros);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// LISTAR UM
	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {
			Optional<Livro> livro = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(livro);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// ATUALIZAR UM
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Livro livro, @PathVariable Long id) {
		try {
			_service.atualizar(livro, id);
			return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado com sucesso!");
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