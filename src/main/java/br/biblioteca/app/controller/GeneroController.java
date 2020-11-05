package br.biblioteca.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.biblioteca.app.model.Genero;
import br.biblioteca.app.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {

	private final GeneroService _service;

	public GeneroController(GeneroService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Genero genero) {

		try {
			_service.criar(genero);
			return ResponseEntity.status(HttpStatus.CREATED).body("Genero inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Genero> generos = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(generos);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		Optional<Genero> genero = _service.listar(id);
		return ResponseEntity.status(HttpStatus.OK).body(genero);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Genero genero, @PathVariable Long id) {
		_service.atualizar(genero, id);
		return ResponseEntity.status(HttpStatus.OK).body("Genero atualizado com sucesso!");
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		_service.deletar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
