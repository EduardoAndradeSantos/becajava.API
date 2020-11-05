package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}