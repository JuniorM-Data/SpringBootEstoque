package br.edu.unichristus.backend.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	private String endereco;
	private String categoria;
	@Column(unique = true)
	private String CNPJ;
	
	public Estoque() {
		
	}
	
	public Estoque(Long id, String nome, String endereco, String categoria, String CNPJ) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.CNPJ = CNPJ;
	}
	
	
}
