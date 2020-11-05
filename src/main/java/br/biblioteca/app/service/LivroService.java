package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Livro;
import br.biblioteca.app.repository.LivroRepository;

@Service
public class LivroService {

	final LivroRepository _repository;

	// @Autowired
	public LivroService(LivroRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Livro livro) {

		livro.setId(new Long(0));
		_repository.save(livro);
	}

	// Listar Todos
	public List<Livro> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Livro> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Livro livro, Long id) {

		livro.setId(id);
		_repository.save(livro);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
