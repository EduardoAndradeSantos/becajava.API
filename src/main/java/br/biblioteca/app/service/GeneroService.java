package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.app.model.*;
import br.biblioteca.app.repository.*;

@Service
public class GeneroService {

	final GeneroRepository _repository;

	// @Autowired
	public GeneroService(GeneroRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Genero genero) {
		genero.setId(new Long(0));
		_repository.save(genero);
	}

	// Listar Todos
	public List<Genero> listar() {
		return _repository.findAll();
	}

	// Listar Somente Um
	public Optional<Genero> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Genero genero, Long id) {
		genero.setId(id);
		_repository.save(genero);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}
