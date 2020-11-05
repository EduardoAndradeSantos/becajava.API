package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Aluno;
import br.biblioteca.app.model.Autor;
import br.biblioteca.app.repository.AlunoRepository;
import br.biblioteca.app.repository.AutorRepository;

@Service
public class AutorService {

	final AutorRepository _repository;

	// @Autowired
	public AutorService(AutorRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Autor autor) {

		autor.setId(new Long(0));
		_repository.save(autor);
	}

	// Listar Todos
	public List<Autor> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Autor> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Autor autor, Long id) {

		autor.setId(id);
		_repository.save(autor);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}
