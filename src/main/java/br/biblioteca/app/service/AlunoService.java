package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.app.model.*;
import br.biblioteca.app.repository.*;

@Service
public class AlunoService {

	final AlunoRepository _repository;

	// @Autowired
	public AlunoService(AlunoRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Aluno aluno) {

		aluno.setId(new Long(0));
		_repository.save(aluno);
	}

	// Listar Todos
	public List<Aluno> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Aluno> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Aluno aluno, Long id) {

		aluno.setId(id);
		_repository.save(aluno);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}
