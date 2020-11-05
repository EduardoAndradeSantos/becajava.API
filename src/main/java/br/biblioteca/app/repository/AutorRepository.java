package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}