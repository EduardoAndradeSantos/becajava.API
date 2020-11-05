package br.biblioteca.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.biblioteca.app.model.Escola;
import br.biblioteca.app.service.EscolaService;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

	private final EscolaService _service;

	public EscolaController(EscolaService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Escola escola) {

		try {
			_service.criar(escola);
			return ResponseEntity.status(HttpStatus.CREATED).body("Escola inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Escola> escolas = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(escolas);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		Optional<Escola> escola = _service.listar(id);
		return ResponseEntity.status(HttpStatus.OK).body(escola);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Escola escola, @PathVariable Long id) {
		_service.atualizar(escola, id);
		return ResponseEntity.status(HttpStatus.OK).body("Escola atualizada com sucesso!");
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		_service.deletar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}