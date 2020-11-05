package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Requisicao {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id;
	
	@ManyToOne
	@JoinColumn (name ="Id_aluno")
	private Aluno Aluno;
	
	@ManyToOne
	@JoinColumn (name ="Id_livro")
	private Livro Livro;
	
	
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Aluno getAluno() {
		return Aluno;
	}

	public void setAluno(Aluno aluno) {
		Aluno = aluno;
	}

	public Livro getLivro() {
		return Livro;
	}

	public void setLivro(Livro livro) {
		Livro = livro;
	}
	
}
