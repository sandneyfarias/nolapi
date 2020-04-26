package br.edu.cesmac.nolapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEditoria;
	private String nome;
	
	public Editoria() {
	}
	
	public Editoria(Long idEditoria, String nome) {
		this.idEditoria = idEditoria;
		this.nome = nome;
	}

	public Long getIdEditoria() {
		return idEditoria;
	}

	public void setIdEditoria(Long idEditoria) {
		this.idEditoria = idEditoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
