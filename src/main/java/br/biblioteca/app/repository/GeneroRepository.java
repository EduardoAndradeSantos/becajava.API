package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.biblioteca.app.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
