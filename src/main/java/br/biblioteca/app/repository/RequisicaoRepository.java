package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Requisicao;


@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {

}