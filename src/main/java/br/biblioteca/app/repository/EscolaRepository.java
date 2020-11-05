package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

}