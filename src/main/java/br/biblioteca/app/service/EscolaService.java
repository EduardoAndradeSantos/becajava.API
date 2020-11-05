package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.app.model.*;
import br.biblioteca.app.repository.*;

@Service
public class EscolaService {
	
	final EscolaRepository _repository;

	// @Autowired
	public EscolaService(EscolaRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Escola escola) {
		escola.setId(new Long(0));
		_repository.save(escola);
	}

	// Listar Todos
	public List<Escola> listar() {
		return _repository.findAll();
	}

	// Listar Somente Um
	public Optional<Escola> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Escola escola, Long id) {
		escola.setId(id);
		_repository.save(escola);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}
