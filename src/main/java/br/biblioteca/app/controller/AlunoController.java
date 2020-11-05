package br.biblioteca.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.biblioteca.app.model.Aluno;
import br.biblioteca.app.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	// PROPRIEDADES
	private final AlunoService _service;

	// CONSTRUTOR
	public AlunoController(AlunoService service) {
		_service = service;
	}

	// CRIAR
	@PostMapping
	public ResponseEntity criar(@RequestBody Aluno aluno) {
		try {
			_service.criar(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body("Aluno inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// LISTAR TODOS
	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Aluno> alunos = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(alunos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// LISTAR UM
	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {
			Optional<Aluno> aluno = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(aluno);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}

	// ATUALIZAR UM
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {
		try {
			_service.atualizar(aluno, id);
			return ResponseEntity.status(HttpStatus.OK).body("Aluno atualizado com sucesso!");
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