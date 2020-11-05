package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id;
	public String Titulo; 
	public int NumeroPaginas;
	
	
	@ManyToOne
	@JoinColumn (name ="Id_categoria")
	private Categoria Categoria;
	
	
	@ManyToOne
	@JoinColumn (name ="Id_autor")
	private Autor Autor;

	
	
	

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
	}


	public int getNumeroPaginas() {
		return NumeroPaginas;
	}


	public void setNumeroPaginas(int numeroPaginas) {
		NumeroPaginas = numeroPaginas;
	}


	public Categoria getCategoria() {
		return Categoria;
	}


	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}


	public Autor getAutor() {
		return Autor;
	}


	public void setAutor(Autor autor) {
		Autor = autor;
	}

}
