package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Requisicao;
import br.biblioteca.app.repository.RequisicaoRepository;

@Service
public class RequisicaoService {

	final RequisicaoRepository _repository;

	// @Autowired
	public RequisicaoService(RequisicaoRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Requisicao requisicao) {

		requisicao.setId(new Long(0));
		_repository.save(requisicao);
	}

	// Listar Todos
	public List<Requisicao> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Requisicao> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Requisicao requisicao, Long id) {

		requisicao.setId(id);
		_repository.save(requisicao);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
