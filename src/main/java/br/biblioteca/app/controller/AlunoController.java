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

	private final AlunoService _service;

	public AlunoController(AlunoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Aluno aluno) {

		try {
			_service.criar(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body("Aluno inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Aluno> alunos = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		Optional<Aluno> aluno = _service.listar(id);
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {
		_service.atualizar(aluno, id);
		return ResponseEntity.status(HttpStatus.OK).body("Aluno atualizado com sucesso!");
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		_service.deletar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
