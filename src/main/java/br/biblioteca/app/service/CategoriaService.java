package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Categoria;
import br.biblioteca.app.repository.CategoriaRepository;

@Service
public class CategoriaService {

	final CategoriaRepository _repository;

	// @Autowired
	public CategoriaService(CategoriaRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Categoria categoria) {

		categoria.setId(new Long(0));
		_repository.save(categoria);
	}

	// Listar Todos
	public List<Categoria> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Categoria> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Categoria categoria, Long id) {

		categoria.setId(id);
		_repository.save(categoria);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
